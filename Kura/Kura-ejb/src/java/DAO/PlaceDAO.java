/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Place;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class PlaceDAO implements PlaceDAOLocal {

    @PersistenceContext(unitName = "Kura-ejbPU")

    private EntityManager em;

    @Override
    public List<Place> showPlaces() throws Exception {
        Query query = em.createQuery("SELECT p FROM Place p", Place.class);
        return query.getResultList();
    }

    @Override
    public boolean deletePlace(int idplace) throws Exception {
        em.remove(em.getReference(Place.class, idplace));
        return true;
    }

    @Override
    public boolean editPlace(String adress, String city, int objecttype, String name, int idplace) {
        Place place = em.getReference(Place.class, idplace);
        place.setAdress(adress);
        place.setCity(city);
        place.setObjecttype(objecttype);
        place.setName(name);
        em.merge(place);
        return true;
    }

    @Override
    public void addPlace(String adress, String city, int objecttype, String name) throws Exception {
        Place place = new Place();
        place.setAdress(adress);
        place.setCity(city);
        place.setObjecttype(objecttype);
        place.setName(name);
        em.persist(place);
    }

      @Override
    public Place getPlace(int idplace) throws Exception {      
        Query query = em.createQuery("SELECT p FROM Place p where p.idplace=?1", Place.class);
        query.setParameter(1, idplace);       
        return (Place) query.getSingleResult();
    }
    
     @Override
     public List<Place> getListPlace() throws Exception{                  
        Query query = em.createQuery("SELECT s FROM Place s", Place.class);
        return query.getResultList();        
     }
}
