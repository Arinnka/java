/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import DAO.StuffDAOLocal;
import Model.Stuff;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;


@Named(value = "stuffBean")
@SessionScoped
public class StuffBean implements Serializable {

    @EJB

    StuffDAOLocal stuffDAOLocal;

    private int idstuff;
    private String stuffname;
    private String stufftype;
    private int price;

    public List<Stuff> getStuffInformation() throws Exception {
        return stuffDAOLocal.showStuff();
    }

    public String addStuff() throws Exception {

        stuffDAOLocal.addStuff(stuffname, stufftype, price);
        return "/Stuff.xhtml";
    }

    public String editStuff() throws Exception {

        stuffDAOLocal.editStuff(stuffname, stufftype, price, idstuff);

        return "/Stuff.xhtml";

    }
    
    public List<Stuff> getListStuff() throws Exception{
        return stuffDAOLocal.getListStuff();
    }

    public void deleteStuff(int myid) throws Exception {
        stuffDAOLocal.deleteStuff(myid);

    }

    public String toStuff(int myid) {
        idstuff = myid;
        return "/editStuff.xhtml";

    }

    /**
     * @return the idstuff
     */
    public int getIdstuff() {
        return idstuff;
    }

    /**
     * @param idstuff the idstuff to set
     */
    public void setIdstuff(int idstuff) {
        this.idstuff = idstuff;
    }

    /**
     * @return the stuffname
     */
    public String getStuffname() {
        return stuffname;
    }

    /**
     * @param stuffname the stuffname to set
     */
    public void setStuffname(String stuffname) {
        this.stuffname = stuffname;
    }

    /**
     * @return the stufftype
     */
    public String getStufftype() {
        return stufftype;
    }

    /**
     * @param stufftype the stufftype to set
     */
    public void setStufftype(String stufftype) {
        this.stufftype = stufftype;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the amount
     */
   

}
