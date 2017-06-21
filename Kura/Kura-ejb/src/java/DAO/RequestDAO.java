/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Place;
import Model.Request;
import Model.Stuff;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class RequestDAO implements RequestDAOLocal {

    @PersistenceContext(unitName = "Kura-ejbPU")

    private EntityManager em;

    @Override
    public List<Request> showRequests() throws Exception {

        Query query = em.createQuery("SELECT r FROM Request r", Request.class);
        return query.getResultList();
    }

    @Override
    public boolean deleteRequest(int idrequest) throws Exception {
        em.remove(em.getReference(Request.class, idrequest));
        return true;
    }

    @Override
    public boolean editRequest(Stuff stuff, int amount, Place idplace, int idrequest) {
        Request request = em.getReference(Request.class, idrequest);
        request.setIdstuff(stuff);
        request.setAmount(amount);        
        request.setIdplace(idplace);        
        em.merge(request);
        return true;
    }

    @Override
    public Request addRequest(Stuff stuff, int amount, Place idplace) throws Exception {
        Request request = new Request();
        request.setIdstuff(stuff);
        request.setAmount(amount);        
        request.setIdplace(idplace);
        em.persist(request);
        em.flush();
        return request;
    }

   
     @Override
    public Request getRequest(int idrequest) throws Exception {      
        Query query = em.createQuery("SELECT r FROM Request r where r.idrequest=?1", Request.class);
        query.setParameter(1, idrequest);       
        return (Request) query.getSingleResult();
    }
    
    
}
