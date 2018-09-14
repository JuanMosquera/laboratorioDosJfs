/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import com.udea.NewSessionBean;
import com.udea.entity.Customer;
import com.udea.entity.DiscountCode;
import com.udea.entity.MicroMarket;
import com.udea.session.CustomerManager;
import com.udea.session.DiscountCodeManagerLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 *
 * @author jfwc1
 */
@Named(value = "customerMBean")
@SessionScoped
public class CustomerMBean implements Serializable {

    @EJB
    private CustomerManager customerManager;

    @EJB
    private DiscountCodeManagerLocal discountCodeManager;

    @EJB
    private com.udea.session.ZipCodeManagerLocal zipCodeManager;

    private Customer customer;
    private List<Customer> customers;
    /**
     * Creates a new instance of CustomerMBean
     */
    public CustomerMBean() {
    }
    
    public List<Customer> getCustomers(){
        if ((customers==null)||(customers.isEmpty())) {
            refresh();
            
        }
        return customers;
    }
    
    public Customer getDetails(){
        return customer;
    }
    
    public String showDetails(Customer customer){
        this.customer = customer;
        return "DETAILS";
    }
    
    public String update(){
        System.out.println("###UPDATE###");
        customer = customerManager.update(customer);
        return "SAVED";
    }
    
    public String list(){
        System.out.println("###LIST###");
        return "LIST";
    }
    
    private void refresh(){
        customers= customerManager.getAllCustomers();
    }
    
    public javax.faces.model.SelectItem[] getDiscountCodes(){
        selectItem[] options = null;
        List<DiscountCode> discountCodes = discountCodeManager.getDiscountCodes();
        if (discountCodes != null && discountCodes.size() > 0) {
            int i = 0;
            options = new SelectItem[discountCodes.size()];
            for (DiscountCode dc : discountCodes) {
                options[i++] = new SelectItem(dc.getDiscountCode(),dc.getDiscountCode()+ "("+ dc.getRate()+"%)");
            }
        }
        return options;
    }
    
    public javax.faces.model.SelectItem[] getZipCodes(){
        SelectItem[] options = null;
        List<MicroMarket> zipCodes = zipCodeManager.getZipCodes();
        if(zipCodes != null && zipCodes.size() >0 ){
            int i = 0;
            options = new SelectItem[zipCodes.size()];
            for(MicroMarket dc : zipCodes){
                options[i++] = new SelectItem(dc.getZipCode(),dc.getZipCode());
            }
        }
        return options;
    }
    
    
}
