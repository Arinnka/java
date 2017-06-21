/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Place;
import Model.Stuff;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class StuffDAO implements StuffDAOLocal {
    
    @PersistenceContext(unitName = "Kura-ejbPU")
    
    private EntityManager em;
    
    @Override
    public List<Stuff> showStuff() throws Exception {
        Query query = em.createQuery("SELECT s FROM Stuff s", Stuff.class);
        return query.getResultList();
    }
    
    @Override
    public boolean deleteStuff(int idstuff) throws Exception {
        em.remove(em.getReference(Stuff.class, idstuff));
        return true;
    }
    
    @Override
    public boolean editStuff(String stuffname, String stufftype, int price, int idstuff) {
        Stuff stuff = em.getReference(Stuff.class, idstuff);
        stuff.setStuffname(stuffname);
        stuff.setStufftype(stufftype);
        stuff.setPrice(price);  
        em.merge(stuff);
        return true;
    }
    
    @Override
    public void addStuff(String stuffname, String stufftype, int price) throws Exception {
        Stuff stuff = new Stuff();
        stuff.setStuffname(stuffname);
        stuff.setStufftype(stufftype);
        stuff.setPrice(price);        
        em.persist(stuff);
    }
    
     @Override
    public Stuff getStuff(int idstuff) throws Exception {      
        Query query = em.createQuery("SELECT s FROM Stuff s where s.idstuff=?1", Stuff.class);
        query.setParameter(1, idstuff);       
        return (Stuff) query.getSingleResult();
    }
    
    @Override
     public List<Stuff> getListStuff() throws Exception{
                  
        Query query = em.createQuery("SELECT s FROM Stuff s", Stuff.class);
        
        return query.getResultList();
        
     }
     
    
    
}
