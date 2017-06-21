/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import DAO.RequestDAOLocal;
import DAO.ReviewDAOLocal;
import DAO.StuffDAOLocal;
import DAO.ZUsersDAOLocal;
import Model.Request;
import Model.Review;
import Model.ZUsers;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;


@Named(value = "reviewBean")
@SessionScoped
public class ReviewBean implements Serializable {

    @EJB
    RequestDAOLocal requestDAOLocal;

    @EJB
    StuffDAOLocal stuffDAOLocal;
    
    @EJB   
    ReviewDAOLocal reviewDAOLocal;
    
      @EJB   
    ZUsersDAOLocal zusersDAOLocal;
    
    private Integer idreview;
    private Request idrequest;
    private ZUsers  zusers;
    
    public void deleteReview(int myid) throws Exception 
    
    {
        reviewDAOLocal.deleteReview(myid);

    }   
    
    public String editReview(int idreview) throws Exception {
        
        reviewDAOLocal.editReview(idreview);
        
        return "/Placa.xhtml";
            
    }
    
        public String editReview1(int idreview) throws Exception {
        
        reviewDAOLocal.editReview1(idreview);
        
        return "/Placa.xhtml";
            
    }
    public List<Review> getReviewInformation() throws Exception {
        return reviewDAOLocal.showReviews();
    }

    /**
     * @return the idreview
     */
    public Integer getIdreview() {
        return idreview;
    }

    /**
     * @param idreview the idreview to set
     */
    public void setIdreview(Integer idreview) {
        this.idreview = idreview;
    }

    /**
     * @return the idrequest
     */
    public Request getIdrequest() {
        return idrequest;
    }

    /**
     * @param idrequest the idrequest to set
     */
    public void setIdrequest(Request idrequest) {
        this.idrequest = idrequest;
    }

    public ZUsers getZusers() {
        return zusers;
    }

    public void setZusers(ZUsers zusers) {
        this.zusers = zusers;
    }

    /**
     * @return the iduser
     */
 
}
