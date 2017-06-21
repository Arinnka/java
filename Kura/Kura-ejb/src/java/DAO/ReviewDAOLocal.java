/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Request;
import Model.Review;
import Model.ZUsers;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Vladimir
 */
@Local
public interface ReviewDAOLocal {

    List<Review> showReviews() throws Exception;

    public boolean deleteReview(int idreview) throws Exception;

    public boolean editReview(int idreview) throws Exception;
    public boolean editReview1(int idreview) throws Exception;
    
    public Review getReview(int idreview) throws Exception;

    public void addReview(Request request, String username) throws Exception;
}
