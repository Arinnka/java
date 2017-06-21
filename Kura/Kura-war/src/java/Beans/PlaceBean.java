/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import DAO.PlaceDAOLocal;
import Model.Place;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;


@Named(value = "placeBean")
@SessionScoped
public class PlaceBean implements Serializable {

    @EJB

    PlaceDAOLocal placeDAOLocal;

    private int idplace;
    private String adress;
    private String city;
    private int objecttype;
    private String name;
    private Place place;

    public List<Place> getPlacesInformation() throws Exception {
       return placeDAOLocal.showPlaces();
    }
    
    public String addPlace() throws Exception {
        
        placeDAOLocal.addPlace(adress,city, objecttype, name);
        return "/Placa.xhtml";
    }
    
     public List<Place> getListPlace() throws Exception{
        return placeDAOLocal.getListPlace();
    }
    
 public String editPlace() throws Exception {
        
        placeDAOLocal.editPlace( adress, city, objecttype, name, idplace);
        
        return "/Placa.xhtml";
            
    }
 
 public void deletePlace(int myid) throws Exception{
     placeDAOLocal.deletePlace(myid);
     
 } 
         
 
 
 public String toPlace(int myid ) {
     idplace = myid;
     return "/editPlaca.xhtml";
     
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
     * @return the address
     */
    public String getAdress() {
        return adress;
    }

    /**
     * @param adress the address to set
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the objecttype
     */
    public int getObjecttype() {
        return objecttype;
    }

    /**
     * @param objecttype the objecttype to set
     */
    public void setObjecttype(int objecttype) {
        this.objecttype = objecttype;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the place
     */
    public Place getPlace() {
        return place;
    }

    /**
     * @param place the place to set
     */
    public void setPlace(Place place) {
        this.place = place;
    }

}
