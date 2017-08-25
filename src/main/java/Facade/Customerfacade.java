/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Customer;
import Entity.Itemtype;
import Entity.Orderline;
import Entity.Orders;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author felesiah
 */
public class Customerfacade {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_Ex1_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
    public Customer createCustomer(){     
        Customer cus = new Customer();
              
        cus.setName("Yolanda");
        cus.setEmail("yolly@gmail.com");
      
        try{
            em.getTransaction().begin();
            em.persist(cus); 
            em.getTransaction().commit();
            } finally {
            em.close();
           
            System.out.println("customer" + " " + cus.getName() +" " +"email: "+ " " + cus.getEmail());
           
        
    }         
    return cus;
}
     public List<Customer> findCustomer(){
    
         Query q = em.createNamedQuery("Customer.findByName");
         q.setParameter("name","Yolanda");
         List<Customer> cust = (List<Customer>)q.getResultList();  
         System.out.println(cust);
      
    return cust;
 }
     public List<Customer> getAllCustomer(){
     
         Query q = em.createNamedQuery("Customer.findAll");
         List<Customer> cust = (List<Customer>)q.getResultList();  
         System.out.println(cust);
      
    return cust;
     
     
     
     } 
  public void CreateOrder(int id) {
 
        em.getTransaction().begin();
        List<Customer> cus = findCustomer();
        Orders o = new Orders();
        o.setOrderID(id);
        cus.get(0).addOrders(o);
       try{
        em.merge(cus.get(0));
        em.persist(o);
        em.getTransaction().commit();
       }finally{
        em.close();
       }
    }
  
   public void createOrderLine(int quanity, Orders order, Itemtype item) {
        try{
            
        Orderline od = new Orderline();
        od.setItems(item);
        od.setOrder(order);
        od.setQuantity(quanity);
        
            em.getTransaction().begin();
            em.persist(od); 
            em.getTransaction().commit();
            } finally {
            em.close();
       
    }
   }
  
  
   public double findTotalPrice(Orders order) {
        Query query = em.createQuery("SELECT line FROM OrderLine line WHERE line.order.id = " + order.getOrderID());
        List<Orderline> list = query.getResultList();
        int sum = 0;
        for(Orderline line : list) {
            sum = line.getItems().getPrice() * line.getQuantity();
        }
        return (double) sum;
    }
 
}
