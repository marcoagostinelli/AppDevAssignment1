/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdev_2;

import java.util.Date;

/**
 *
 * @author marco
 */
public class Visit {
    private Customer customer;
    private Date date;
    private double serviceExpense;
    private double productExpense;
    
    public Visit(String name,Date date){
        customer = new Customer(name);
        this.date=date;
    }
    public String getName(){
        return customer.getName();
    }

    public void setServiceExpense(double serviceExpense) {
        this.serviceExpense = serviceExpense;
    }

    public void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }
    

    public double getServiceExpense() {
        return serviceExpense;
    }

    public double getProductExpense() {
        return productExpense;
    }
    
    public double getTotalExpense(){
        return serviceExpense + productExpense;
    }

    @Override
    public String toString() {
        return "Visit{" + "customer=" + customer + ", date=" + date + ", serviceExpense=" + serviceExpense + ", productExpense=" + productExpense + '}';
    }
    
    
}
