/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Place;
import Model.Request;
import Model.Stuff;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;


@Local
public interface RequestDAOLocal {

    List<Request> showRequests() throws Exception;

    public boolean deleteRequest(int idrequest) throws Exception;

    public boolean editRequest(Stuff stuff, int amount, Place place, int idrequest);

    public Request addRequest( Stuff stuff, int amount, Place place) throws Exception;

    public Request getRequest(int idrequest) throws Exception;
}
