/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ZUsers;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class ZUsersDAO implements ZUsersDAOLocal {

    @PersistenceContext(unitName = "Kura-ejbPU")

    private EntityManager em;

    @Override
    public List<ZUsers> showZUsers() throws Exception {
        Query query = em.createQuery("SELECT z FROM ZUsers z", ZUsers.class);
        return query.getResultList();
    }

    @Override
    public ZUsers getZUsers(int idUser) throws Exception {
        Query query = em.createQuery("SELECT z FROM ZUsers z where z.idUser=?1", ZUsers.class);
        query.setParameter(1, idUser);
        return (ZUsers) query.getSingleResult();
    }

}
