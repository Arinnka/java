/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import DAO.ReportDAOLocal;
import Model.Report;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;


@Named(value = "reportBean")
@SessionScoped
public class ReportBean implements Serializable {

   @EJB
   
   ReportDAOLocal reportDAOLocal;
      
   private int idreport;
   private int idplace;
   private int summa;

   public List<Report> getReportInformation() throws Exception {
       return reportDAOLocal.showReports();
    }

    /**
     * @return the idreport
     */
    public int getIdreport() {
        return idreport;
    }

    
  
    /**
     * @param idreport the idreport to set
     */
    public void setIdreport(int idreport) {
        this.idreport = idreport;
    }

    /**
     * @return the idplace
     */
    public int getIdplace() {
        return idplace;
    }

    /**
     * @param idplace the idplace to set
     */
    public void setIdplace(int idplace) {
        this.idplace = idplace;
    }

    /**
     * @return the summa
     */
    public int getSumma() {
        return summa;
    }

    /**
     * @param summa the summa to set
     */
    public void setSumma(int summa) {
        this.summa = summa;
    }
   
   
}
