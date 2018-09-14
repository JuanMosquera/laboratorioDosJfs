/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.entity.Customer;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jfwc1
 */
@Local
public interface CustomerManagerLocal {

   public List<Customer> getAllCustomers();

   public Customer update(Customer customer);
    
}
