/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.entity.Payment;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jfwc1
 */
@Stateless
public class PaymentManager implements PaymentManagerLocal {

    @PersistenceContext(unitName = "com.udea_LaboratorioDos-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;
//    @Resource
//    private javax.transaction.UserTransaction utx;

    @Override
    public List<Payment> getAllPayment() {
        Query query = em.createNamedQuery("Payment.findAll");
        return query.getResultList() ;
    }

    @Override
    public Payment update(Payment payment) {
        return em.merge(payment);
    }

//    public void persist(Object object) {
//        try {
//            utx.begin();
//            em.persist(object);
//            utx.commit();
//        } catch (Exception e) {
//            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
//            throw new RuntimeException(e);
//        }
//    }

   
}
