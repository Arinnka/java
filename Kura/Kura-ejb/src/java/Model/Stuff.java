/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "stuff")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stuff.findAll", query = "SELECT s FROM Stuff s"),
    @NamedQuery(name = "Stuff.findByIdstuff", query = "SELECT s FROM Stuff s WHERE s.idstuff = :idstuff"),
    @NamedQuery(name = "Stuff.findByStuffname", query = "SELECT s FROM Stuff s WHERE s.stuffname = :stuffname"),
    @NamedQuery(name = "Stuff.findByStufftype", query = "SELECT s FROM Stuff s WHERE s.stufftype = :stufftype"),
    @NamedQuery(name = "Stuff.findByPrice", query = "SELECT s FROM Stuff s WHERE s.price = :price")})
public class Stuff implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idstuff")
    private Integer idstuff;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "stuffname")
    private String stuffname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "stufftype")
    private String stufftype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private int price;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idstuff")
    private List<Request> requestList;

    public Stuff() {
    }

    public Stuff(Integer idstuff) {
        this.idstuff = idstuff;
    }

    public Stuff(Integer idstuff, String stuffname, String stufftype, int price) {
        this.idstuff = idstuff;
        this.stuffname = stuffname;
        this.stufftype = stufftype;
        this.price = price;
    }

    public Integer getIdstuff() {
        return idstuff;
    }

    public void setIdstuff(Integer idstuff) {
        this.idstuff = idstuff;
    }

    public String getStuffname() {
        return stuffname;
    }

    public void setStuffname(String stuffname) {
        this.stuffname = stuffname;
    }

    public String getStufftype() {
        return stufftype;
    }

    public void setStufftype(String stufftype) {
        this.stufftype = stufftype;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @XmlTransient
    public List<Request> getRequestList() {
        return requestList;
    }

    public void setRequestList(List<Request> requestList) {
        this.requestList = requestList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idstuff != null ? idstuff.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stuff)) {
            return false;
        }
        Stuff other = (Stuff) object;
        if ((this.idstuff == null && other.idstuff != null) || (this.idstuff != null && !this.idstuff.equals(other.idstuff))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Stuff[ idstuff=" + idstuff + " ]";
    }
    
}
