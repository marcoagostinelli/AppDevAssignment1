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
public class Customer {
    private String name;
    private boolean member=false;
    private String memberType;
    
    public Customer(String name){
        this.name=name;
    }
    
    public String getName(){
        return name;
    }
    
    public boolean isMember(){
        return member;
    }
    
    public void setMember(boolean member){
        this.member = member;
    }
    
    public String getMemberType(){
        if (memberType != null){
          return memberType;  
        }
        return "";//returns an empty string if not a member
        
    }
    
    public void setMemberType(String type){
        this.memberType = type;
    }

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", member=" + member + ", memberType=" + memberType + '}';
    }
    
    
}
