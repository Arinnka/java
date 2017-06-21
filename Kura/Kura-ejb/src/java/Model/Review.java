/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "review")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Review.findAll", query = "SELECT r FROM Review r"),
    @NamedQuery(name = "Review.findByIdreview", query = "SELECT r FROM Review r WHERE r.idreview = :idreview"),
    @NamedQuery(name = "Review.findByStatus", query = "SELECT r FROM Review r WHERE r.status = :status")})
public class Review implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idreview")
    private Integer idreview;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private ZUsers idUser;
    @JoinColumn(name = "idrequest", referencedColumnName = "idrequest")
    @ManyToOne(optional = false)
    private Request idrequest;

    public Review() {
    }

    public Review(Integer idreview) {
        this.idreview = idreview;
    }

    public Review(Integer idreview, String status) {
        this.idreview = idreview;
        this.status = status;
    }

    public Integer getIdreview() {
        return idreview;
    }

    public void setIdreview(Integer idreview) {
        this.idreview = idreview;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ZUsers getIdUser() {
        return idUser;
    }

    public void setIdUser(ZUsers idUser) {
        this.idUser = idUser;
    }

    public Request getIdrequest() {
        return idrequest;
    }

    public void setIdrequest(Request idrequest) {
        this.idrequest = idrequest;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreview != null ? idreview.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Review)) {
            return false;
        }
        Review other = (Review) object;
        if ((this.idreview == null && other.idreview != null) || (this.idreview != null && !this.idreview.equals(other.idreview))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Review[ idreview=" + idreview + " ]";
    }
    
}
