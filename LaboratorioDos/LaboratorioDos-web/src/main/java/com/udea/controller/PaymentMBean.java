/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import com.udea.entity.Payment;
import com.udea.session.PaymentManagerLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author jfwc1
 */
//@Named(value="paymentMBean")
//@SessionScoped
public class PaymentMBean implements Serializable{

    @EJB
    private PaymentManagerLocal paymentManager;

    @EJB
    private com.udea.entity.NewSessionBean newSessionBean;
    
    private Payment payment;
    private List<Payment> payments;
    /**
     * Creates a new instance of PaymentMBean
     */
    public PaymentMBean() {
    }
    
    public List<Payment> getPayments(){
            if((payments==null) || (payments.isEmpty()))
            refresh();
            return payments;
    }

    public Payment getDetails(){
    return payment;
    }

    public String showDetails(Payment payment){
    this.payment = payment;
    return "DETAILS";
    }

    public String update(){
    System.out.println("###UPDATE###");
    payment = paymentManager.update(payment);
    return "SAVED";
    }

    public String list(){
    System.out.println("###LIST###");
    return "LIST";
    }

    private void refresh(){
    payments = paymentManager.getAllPayment();
    }

//    public javax.faces.model.SelectItem[] getDiscountCodes(){
//            SelectItem[] options = null;
//            List<DiscountCode> discountCodes = discountCodeManager.getDiscountCode();
//            if(discountCodes != null && discountCodes.size()>0){
//                int i=0;
//                options = new SelectItem[discountCodes.seze()];
//                for(DiscountCode dc : discountCodes){
//                        options[i++] = new SelectItem(dc.getDiscountCode(),
//                        dc.getDiscountCode()+ "("+dc.getRate()+"%)");
//                }
//            }
//            return options;
//    }
}
