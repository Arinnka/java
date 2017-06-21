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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "report")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Report.findAll", query = "SELECT r FROM Report r"),
    @NamedQuery(name = "Report.findByIdreport", query = "SELECT r FROM Report r WHERE r.idreport = :idreport"),
    @NamedQuery(name = "Report.findByIdplace", query = "SELECT r FROM Report r WHERE r.idplace = :idplace"),
    @NamedQuery(name = "Report.findBySumma", query = "SELECT r FROM Report r WHERE r.summa = :summa")})
public class Report implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idreport")
    private Integer idreport;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idplace")
    private int idplace;
    @Basic(optional = false)
    @NotNull
    @Column(name = "summa")
    private int summa;
    @Transient
    private String placename;

    public String getPlacename() {
        return placename;
    }

    public void setPlacename(String placename) {
        this.placename = placename;
    }

    public Report(Integer idreport, int summa, String placename) {
        this.idreport = idreport;
        this.summa = summa;
        this.placename = placename;
    }

    
    
    public Report() {
    }

    public Report(Integer idreport) {
        this.idreport = idreport;
    }

    public Report(Integer idreport, int idplace, int summa) {
        this.idreport = idreport;
        this.idplace = idplace;
        this.summa = summa;
    }

    public Integer getIdreport() {
        return idreport;
    }

    public void setIdreport(Integer idreport) {
        this.idreport = idreport;
    }

    public int getIdplace() {
        return idplace;
    }

    public void setIdplace(int idplace) {
        this.idplace = idplace;
    }

    public int getSumma() {
        return summa;
    }

    public void setSumma(int summa) {
        this.summa = summa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreport != null ? idreport.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Report)) {
            return false;
        }
        Report other = (Report) object;
        if ((this.idreport == null && other.idreport != null) || (this.idreport != null && !this.idreport.equals(other.idreport))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Report[ idreport=" + idreport + " ]";
    }
    
}
