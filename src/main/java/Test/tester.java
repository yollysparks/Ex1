/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entity.Customer;
import Facade.Customerfacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author felesiah
 */
public class tester {
    public static void main(String[] args) {
        
        
        Customerfacade cf = new Customerfacade();
        cf.createCustomer();
        cf.findCustomer();
        cf.getAllCustomer();
  
        
        
    }
}
