/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Report;
import java.util.List;
import javax.ejb.Local;


@Local
public interface ReportDAOLocal {
     List<Report> showReports() throws Exception;
  
}