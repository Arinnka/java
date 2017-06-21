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
@Table(name = "place")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Place.findAll", query = "SELECT p FROM Place p"),
    @NamedQuery(name = "Place.findByIdplace", query = "SELECT p FROM Place p WHERE p.idplace = :idplace"),
    @NamedQuery(name = "Place.findByAdress", query = "SELECT p FROM Place p WHERE p.adress = :adress"),
    @NamedQuery(name = "Place.findByCity", query = "SELECT p FROM Place p WHERE p.city = :city"),
    @NamedQuery(name = "Place.findByObjecttype", query = "SELECT p FROM Place p WHERE p.objecttype = :objecttype"),
    @NamedQuery(name = "Place.findByName", query = "SELECT p FROM Place p WHERE p.name = :name")})
public class Place implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idplace")
    private Integer idplace;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "adress")
    private String adress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Column(name = "objecttype")
    private int objecttype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idplace")
    private List<Request> requestList;

    public Place() {
    }

    public Place(Integer idplace) {
        this.idplace = idplace;
    }

    public Place(Integer idplace, String adress, String city, int objecttype, String name) {
        this.idplace = idplace;
        this.adress = adress;
        this.city = city;
        this.objecttype = objecttype;
        this.name = name;
    }

    public Integer getIdplace() {
        return idplace;
    }

    public void setIdplace(Integer idplace) {
        this.idplace = idplace;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getObjecttype() {
        return objecttype;
    }

    public void setObjecttype(int objecttype) {
        this.objecttype = objecttype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        hash += (idplace != null ? idplace.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Place)) {
            return false;
        }
        Place other = (Place) object;
        if ((this.idplace == null && other.idplace != null) || (this.idplace != null && !this.idplace.equals(other.idplace))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Place[ idplace=" + idplace + " ]";
    }
    
}
