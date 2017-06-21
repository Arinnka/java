/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import DAO.PlaceDAOLocal;
import DAO.RequestDAOLocal;
import DAO.ReviewDAOLocal;
import DAO.StuffDAOLocal;
import Model.Place;
import Model.Request;
import Model.Stuff;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;


@Named(value = "requestBean")
@SessionScoped
public class RequestBean implements Serializable {

    @EJB
    RequestDAOLocal requestDAOLocal;

    @EJB
    StuffDAOLocal stuffDAOLocal;

    @EJB
    PlaceDAOLocal placeDAOLocal;

    @EJB
    ReviewDAOLocal reviewDAOLocal;
       
    private int idrequest;
    private int idstuff;
    private int amount;
    private int idplace;

    public List<Request> getRequestInformation() throws Exception {
        return requestDAOLocal.showRequests();
    }
       
    @PostConstruct
    public void SSS(){          
        idstuff = 0;
        idplace = 0;        
    }
    
    
    public String addRequest() throws Exception {                 
        String somename = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName(); 
        Request request = requestDAOLocal.addRequest(stuffDAOLocal.getStuff(idstuff), amount, placeDAOLocal.getPlace(idplace));         
        reviewDAOLocal.addReview(request, somename);
        return "/Request.xhtml";
    }

    public String editRequest() throws Exception {
        requestDAOLocal.editRequest(stuffDAOLocal.getStuff(idstuff), amount, placeDAOLocal.getPlace(idplace), idrequest);
        return "/Request.xhtml";
    }

    public void deleteRequest(int myid) throws Exception {
        requestDAOLocal.deleteRequest(myid);

    }

    public String toRequest(int myid) {
        setIdrequest(myid);
        return "/editRequest.xhtml";

    }

    /**
     * @return the idrequest
     */
    public int getIdrequest() {
        return idrequest;
    }

    /**
     * @param idrequest the idrequest to set
     */
    public void setIdrequest(int idrequest) {
        this.idrequest = idrequest;
    }

   
    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getIdstuff() {
        return idstuff;
    }

    public void setIdstuff(int idstuff) {
        this.idstuff = idstuff;
    }

    public int getIdplace() {
        return idplace;
    }

    public void setIdplace(int idplace) {
        this.idplace = idplace;
    }

  
}
