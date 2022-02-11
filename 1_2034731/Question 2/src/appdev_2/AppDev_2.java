// --------------------------------------------------------------------
// Assignment (1)
// Written by: (Marco Agostinelli 2034731)
// For Application Development 2 (Mobile) - Winter 2022
// --------------------------------------------------------------------
package appdev_2;

//this program asks customers how much services or products they would like to buy
//and then calculates the discount they get based on their membership
import java.util.Scanner;
import java.util.Date;

public class AppDev_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("What is your name?");
        Customer customer1 = new Customer(input.nextLine());

        System.out.println("What type of member are you? (premium/gold/silver) enter anything else if not a member");
        String memberType = input.nextLine();
        switch (memberType) {
            case "premium":
                customer1.setMember(true);
                customer1.setMemberType("premium");
                break;
            case "gold":
                customer1.setMember(true);
                customer1.setMemberType("gold");
                break;
            case "silver":
                customer1.setMember(true);
                customer1.setMemberType("silver");
                break;
        }
        
        Visit visit1 = new Visit(customer1.getName(),new Date());//create the visit
        
        System.out.println("Services: $10 each, Products: $20 each\n How many services would you like?");//establish base prices
        int services= input.nextInt();
        System.out.println("How many products would you like?");        
        int products = input.nextInt();
        
        visit1.setServiceExpense((services * 10)-(services*10*DiscountRate.getServiceDiscountRate(customer1.getMemberType())));//base cost - discount
        visit1.setProductExpense((products * 20)-(products*10*DiscountRate.getProductDiscountRate(customer1.getMemberType())));
        
        System.out.println("Your total cost for this visit is: $"+visit1.getTotalExpense());
    }

}
