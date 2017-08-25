/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author felesiah
 */
@Entity
@Table(name = "itemtype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itemtype.findAll", query = "SELECT i FROM Itemtype i")
    , @NamedQuery(name = "Itemtype.findById", query = "SELECT i FROM Itemtype i WHERE i.id = :id")
    , @NamedQuery(name = "Itemtype.findByName", query = "SELECT i FROM Itemtype i WHERE i.name = :name")
    , @NamedQuery(name = "Itemtype.findByDescription", query = "SELECT i FROM Itemtype i WHERE i.description = :description")
    , @NamedQuery(name = "Itemtype.findByPrice", query = "SELECT i FROM Itemtype i WHERE i.price = :price")})
public class Itemtype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private String price;

    public Itemtype() {
    }

    public Itemtype(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itemtype)) {
            return false;
        }
        Itemtype other = (Itemtype) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Itemtype[ id=" + id + " ]";
    }
    
}
