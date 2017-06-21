/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Place;
import Model.Stuff;
import java.util.List;
import javax.ejb.Local;



@Local
public interface PlaceDAOLocal {

    List<Place> showPlaces() throws Exception;
       
    public boolean deletePlace(int idplace) throws Exception;

    public boolean editPlace(String adress, String city,  int objecttype, String name, int idplace) ;

    public void addPlace(String adress, String city,  int objecttype, String name) throws Exception ; 

    public Place getPlace(int idplace) throws Exception;
    
    public List<Place> getListPlace() throws Exception;
}
