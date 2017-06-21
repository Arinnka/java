/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Place;
import Model.Report;
import Model.Request;
import Model.Review;
import Model.Stuff;
import Model.ZUsers;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class ReviewDAO implements ReviewDAOLocal {

    @PersistenceContext(unitName = "Kura-ejbPU")

    private EntityManager em;

    @PersistenceContext(unitName = "Kura-ejbPU2")
    private EntityManager em2;

    @Override
    public List<Review> showReviews() throws Exception {

        Query query = em.createQuery("SELECT r FROM Review r", Review.class);
        return query.getResultList();
    }

    @Override
    public boolean deleteReview(int idreview) throws Exception {
        em.remove(em.getReference(Review.class, idreview));
        return true;
    }

    @Override
    public Review getReview(int idreview) throws Exception {
        Query query = em.createQuery("SELECT r FROM Review r where r.idreview=?1", Review.class);
        query.setParameter(1, idreview);
        return (Review) query.getSingleResult();
    }

    @Override
    public void addReview(Request request, String username) throws Exception {
        Review review = new Review();
        review.setIdrequest(request);
        review.setIdUser(em.find(ZUsers.class, username));
        review.setStatus("no");
        em.persist(review);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean editReview(int idreview) {
        
        Review review = em.getReference(Review.class, idreview);
        review.setStatus("yes");  
        
        em.merge(review);
        
        
        Place place = em.getReference(Place.class, review.getIdrequest().getIdplace().getIdplace()); 
        
        Stuff stuff = em.getReference(Stuff.class, review.getIdrequest().getIdstuff().getIdstuff());
      
        Request request = em.getReference(Request.class, review.getIdrequest().getIdrequest());
                
        Query query = em2.createQuery("SELECT r FROM Report r where r.idplace=?1", Report.class);
        
        query.setParameter(1, place.getIdplace());
        
        if (query.getResultList().isEmpty()){
            Report report = new Report();
        
        report.setIdplace(place.getIdplace());
        
        report.setSumma(stuff.getPrice() * request.getAmount());
                
        em2.persist(report); 
        }        
        else {
           Report report = new Report(); 
           report = (Report) query.getResultList().get(0);   
           report.setSumma(report.getSumma() + stuff.getPrice() * request.getAmount());  
           em2.merge(report);
        }
        
        return true;
    }
    
     @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean editReview1(int idreview) {
        
        Review review = em.getReference(Review.class, idreview);
        review.setStatus("no");  
        
        em.merge(review);
        
        
        Place place = em.getReference(Place.class, review.getIdrequest().getIdplace().getIdplace()); 
        
        Stuff stuff = em.getReference(Stuff.class, review.getIdrequest().getIdstuff().getIdstuff());
      
        Request request = em.getReference(Request.class, review.getIdrequest().getIdrequest());
                
        Query query = em2.createQuery("SELECT r FROM Report r where r.idplace=?1", Report.class);
        
        query.setParameter(1, place.getIdplace());
        
        if (query.getResultList().isEmpty()){
            Report report = new Report();
        
        report.setIdplace(place.getIdplace());
        
        report.setSumma(stuff.getPrice() * request.getAmount());
                
        em2.persist(report); 
        }        
        else {
           Report report = new Report(); 
           report = (Report) query.getResultList().get(0);   
           report.setSumma(report.getSumma() - stuff.getPrice() * request.getAmount());  
           em2.merge(report);
        }
        
        return true;
    }
}
