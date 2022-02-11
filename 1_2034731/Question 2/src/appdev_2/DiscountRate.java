/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdev_2;

/**
 *
 * @author marco
 */
public class DiscountRate {
    private static double serviceDiscountPremium=0.2;
    private static double serviceDiscountGold=0.15;
    private static double serviceDiscountSilver=0.1;
    private static double productDiscountPremium=0.1;
    private static double productDiscountGold=0.1;
    private static double productDiscountSilver=0.1;
    
    public static double getServiceDiscountRate(String type){
        switch (type){
            case "premium":
                return serviceDiscountPremium;
            case "gold":
                return serviceDiscountGold;
            default:
                return serviceDiscountSilver;
        }
    }
    
    public static double getProductDiscountRate(String type){
        switch (type){
            case "premium":
                return productDiscountPremium;
            case "gold":
                return productDiscountGold;
            default:
                return productDiscountSilver;
        }
    }
    
}
