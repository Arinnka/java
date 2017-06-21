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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "request")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Request.findAll", query = "SELECT r FROM Request r"),
    @NamedQuery(name = "Request.findByIdrequest", query = "SELECT r FROM Request r WHERE r.idrequest = :idrequest"),
    @NamedQuery(name = "Request.findByAmount", query = "SELECT r FROM Request r WHERE r.amount = :amount")})
public class Request implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrequest")
    private Integer idrequest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private int amount;
    @JoinColumn(name = "idplace", referencedColumnName = "idplace")
    @ManyToOne(optional = false)
    private Place idplace;
    @JoinColumn(name = "idstuff", referencedColumnName = "idstuff")
    @ManyToOne(optional = false)
    private Stuff idstuff;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idrequest")
    private List<Review> reviewList;

    public Request() {
    }

    public Request(Integer idrequest) {
        this.idrequest = idrequest;
    }

    public Request(Integer idrequest, int amount) {
        this.idrequest = idrequest;
        this.amount = amount;
    }

    public Integer getIdrequest() {
        return idrequest;
    }

    public void setIdrequest(Integer idrequest) {
        this.idrequest = idrequest;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Place getIdplace() {
        return idplace;
    }

    public void setIdplace(Place idplace) {
        this.idplace = idplace;
    }

    public Stuff getIdstuff() {
        return idstuff;
    }

    public void setIdstuff(Stuff idstuff) {
        this.idstuff = idstuff;
    }

    @XmlTransient
    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrequest != null ? idrequest.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Request)) {
            return false;
        }
        Request other = (Request) object;
        if ((this.idrequest == null && other.idrequest != null) || (this.idrequest != null && !this.idrequest.equals(other.idrequest))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Request[ idrequest=" + idrequest + " ]";
    }
    
}
