/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.entity.Payment;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jfwc1
 */
@Local
public interface PaymentManagerLocal {

    List<Payment> getAllPayment();

//    PaymentManager update(PaymentManager payment);

    Payment update(Payment payment);
    
}
