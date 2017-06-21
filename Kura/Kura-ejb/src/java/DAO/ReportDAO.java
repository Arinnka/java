/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Model.Place;
import Model.Report;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class ReportDAO implements ReportDAOLocal {

    @PersistenceContext(unitName = "Kura-ejbPU2")
    private EntityManager em2;
    
    @PersistenceContext(unitName = "Kura-ejbPU")
    private EntityManager em;


    @Override
    public List<Report> showReports() throws Exception {
        Query query = em2.createQuery("SELECT r FROM Report r", Report.class);
        List<Report> mylist = new ArrayList<>();
        List<Report> mylist1 = new ArrayList<>();        
        mylist1 = query.getResultList();
        for (Report report : mylist1) {
         Query query1 = em.createQuery("SELECT p FROM Place p where p.idplace=?1", Place.class);
         query1.setParameter(1, report.getIdplace());
         Place place = (Place) query1.getSingleResult();
         mylist.add(new Report(report.getIdreport(),report.getSumma(), place.getName()));
        }
        return mylist;
    }
    

   
}
