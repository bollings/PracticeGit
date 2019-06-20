/*
* Name: Stuart Bollinger
* Assignment: 1
* Program: Computer Programming
*
* Main Class (Assignment 1)
*/
package bollings;

import java.util.Scanner;

/**
 * This class prompts user for inventory data,
 * Uses Inventory class mutator methods to ensure user input validity,
 * Notifies user if Quantity On Hand is less than Re-Order Point,
 * Calculates / displays the cost of the units that the user wants
 * to purchase including tax at 13%
 * 
 * @author Stuart Bollinger
 */
public class Main {  

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // declare input as scanner taking user input 
        Scanner input = new Scanner(System.in);   
        
        //inventory object called userInventoryInput assigned default values
        Inventory userInventoryInput = new Inventory (); 
       
        //declare boolean variable isLegit (used in while-loop)
        boolean isLegit = false;
        
        /*prompt user for Inventory ID (String), invoke setId() method, 
        display error message and prompt user again if input data is invalid*/
        do{
            try{
                System.out.print("Enter Inventory Item ID:"); 
                String id = input.nextLine();
                userInventoryInput.setId(id);
                isLegit = true;
            } catch (Exception ex){
                System.out.println(ex.getMessage());                                     
            }
        }while(isLegit == false);
        
        /*prompt user for Item Name (String), invoke setName() method,  
        display error message and prompt user again if input data is invalid*/
        do{
            try{
                System.out.print("Enter Item Name: "); 
                String name = input.nextLine();
                userInventoryInput.setName(name);
                isLegit = true;
            } catch (Exception ex){
                System.out.println(ex.getMessage());                                 
            }
        }while(isLegit == false);
        
        
        /*prompt user for Quanity on Hand (Int), invoke setQoh() method,  
        display error message and prompt user again if input data is invalid*/
        do{
            try{
               System.out.print("Qty On Hand: ");
               input = new Scanner(System.in);
               int qoh = input.nextInt();
               userInventoryInput.setQoh(qoh);
               isLegit = true;
            } catch (Exception ex){
                System.out.println(ex.getMessage()); 
            }
        }while(isLegit == false);
        
        /*prompt user for Re-Order Point (int), invoke setRop() method, 
        display error message and prompt user again if input data is invalid*/
        do{
            try{
                System.out.print("Re-Order Point: ");
                input = new Scanner(System.in);
                int rop = input.nextInt();
                userInventoryInput.setRop(rop);
                isLegit = true;
            } catch (Exception ex){
                System.out.println(ex.getMessage());                                 
            }
        }while(isLegit == false);
        
        /*prompt user for Selling Price (double), invoke setSellPrice() method,
        display error message and prompt user again if input data is invalid*/
        do{
            try{
                System.out.print("Selling Price: ");
                input = new Scanner(System.in);
                double sellPrice = input.nextDouble();
                userInventoryInput.setSellPrice(sellPrice);
                isLegit = true;
            } catch (Exception ex){
                System.out.print(ex.getMessage());                           
            }
        }while(isLegit == false);
       
        /*if Quantity On Hand is less than Re-Order Point, display message
        reminding they need to order more*/
        if (userInventoryInput.getQoh() <= userInventoryInput.getRop()){
            System.out.println("You need to order more " 
                    + userInventoryInput.getName()+".");
        }
     
       /*prompt user for purchase quantity (int), 
        if number inputted is negative, purchase quantity becomes 0*/
        System.out.print("Enter # of units to purchase:");                      //need to catch inputmismatchexeption...?
        int purchaseQuantity = input.nextInt();
        if (purchaseQuantity < 0){
            purchaseQuantity = 0;
        }
        
        //calculate and display total cost: (Qty * Price) including tax at 13%
        double hST = 0.13;
        double totalCost = purchaseQuantity * userInventoryInput.getSellPrice()
                * (1+hST);
        System.out.printf("Total cost: $%.2f", totalCost);
        System.out.println("\n" + userInventoryInput);            
    }
}