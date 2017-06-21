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
public interface StuffDAOLocal {
     List<Stuff> showStuff() throws Exception;
    
   
    public boolean deleteStuff(int idstuff) throws Exception;

    public boolean editStuff(String stuffname, String stufftype,  int price,  int idstuff) ;

    public void addStuff(String stuffname, String stufftype,  int price) throws Exception ; 

    public Stuff getStuff(int idstuff) throws Exception;    
    
    public List<Stuff> getListStuff() throws Exception;
}
