/*
* Name: Stuart Bollinger
* Assignment: 1
* Program: Computer Programming
*
* Inventory Class (Assignment 1)
*/
package bollings;

/**
 * This class checks the validity of user input values from Main class,
 * Throws customized exception statements if user input is invalid,
 * Includes toString method formatted as per instructions
 * 
 * @author Stuart Bollinger
 */
public class Inventory { 
    
    // declare 5 Inventory variables, with default values assigned
    private String id = "ABC-1234";
    private String name = "New Item";
    private int qoh = 0;
    private int rop = 25;
    private double sellPrice = 0;
    
    /**
     * default constructor 
     */
    public Inventory(){}
   
    /**
     * constructor method using user input (3 of 5 variables)
     * 
     * @param id
     * @param name
     * @param sellPrice 
     */
    public Inventory(String id, String name, double sellPrice){
        setId(id);
        setName(name);
        setSellPrice(sellPrice);
    }                     
    
    /**
     * constructor method from user input (all 5 variables)
     * 
     * @param id
     * @param name
     * @param qoh
     * @param rop
     * @param sellPrice 
     */
    public Inventory(String id, String name, int qoh, int rop,
            double sellPrice){
        
        setId(id);
        setName(name);
        setSellPrice(sellPrice);
        setQoh(qoh);
        setRop(rop);
    }   
    
    /**
     * accessor method for id
     * @return 
     */
    public String getId(){
        
        return id;
    }
    
    /**
     * mutator method for id
     * ensures user input for ID Name is valid
     * @param id 
     */
    public void setId(String id) {          
        
        //id ivalid if not 8 chars long
        if (id.length() != 8){               
            throw new IllegalArgumentException("Error: id must be formatted"
                    + " like AAA-1111.");
        }
        
         //id invalid if first 3 chars not letters
        for (int i = 0; i < 3; i++){   
            if  (id.charAt(i) < 'A' || id.charAt(i) > 'z' || 
                (id.charAt(i) > 'Z' && id.charAt(i)< 'a')){
                throw new IllegalArgumentException("Error: id must be formatted"
                        + " like AAA-1111."); 
            }
        }
        
        //id invalid if 4th char is not dash
        if (id.charAt(3) != '-')              
             throw new IllegalArgumentException("Error: id must be formatted"
                     + " like AAA-1111.");
        
        //id invalid if last 4 chars not numbers
        for (int j = 4; j < 8; j++){        
            if (id.charAt(j) < '0' || id.charAt(j) > '9')
               throw new IllegalArgumentException("Error: id must be formatted"
                       + " like AAA-1111.");
            }     
               
        //store id in all uppercase
        char[] idArray = id.toCharArray();
        for(int k = 0; k < 3; k++){
            idArray[k] = Character.toUpperCase(idArray[k]);            
        }
        id = new String(idArray);
        
        /*if none of the exceptions above are thrown, id is successfully set*/
        this.id = id;
    }
    
    /**
     * accessor method for name
     * @return 
     */
    public String getName(){
        
        return name;
    }
   
    /**
     * mutator method for name 
     * ensures user input for Name is not empty or null
     * @param name 
     */
    public void setName(String name){  
        
        // name cannot be null or empty
        if (name == null || name.equals("")){
            throw new IllegalArgumentException("Error: ID name cannot be"
                    + " empty.");
        } 
        this.name = name;
    }
    
    /**
     * accessor method for Quantity on Hand
     * @return 
     */
    public int getQoh() {
        
        return qoh;
    }
    
    /**
     * mutator method for Quantity On Hand
     * ensures user input for Quantity On Hand is zero or greater
     * @param qoh 
     */
    public void setQoh(int qoh){
        
        /*Quantity On Hand must be zero or greater*/
        if (qoh < 0){
            throw new IllegalArgumentException("Error: Quantity On Hand cannot"
                    + " be negative.");
        }   
        this.qoh = qoh;
    }
    
    /**
     * accessor method for Re-Order Point
     * @return 
     */
    public int getRop(){
        
        return rop;          
    }
    
    /**
     * mutator method for Re-Order Point
     * ensures user input for Re-Order Point is zero or greater
     * @param rop 
     */
    public void setRop(int rop) {
        
        //Re-Order Point cannot be less than 0
        if (rop < 0){
            throw new IllegalArgumentException("Error: Re-Order Point cannot"
                    + " be negative");   
        }
        this.rop = rop;
    }
    
    /**
     * accessor method for Selling Price
     * @return 
     */
    public double getSellPrice() {
        
        return sellPrice;
    }
    
    /**
     * Mutator method for Selling Price
     * Ensure user input for Selling Price is zero or greater
     * @param sellPrice 
     */
    public void setSellPrice(double sellPrice){  
        
        if (sellPrice < 0){
            throw new IllegalArgumentException("Error: Selling Price cannot be"
                    + " negative");
        }
        this.sellPrice = sellPrice;
    }
    
    /**
     * toString method
     * ellipses used for names greater than 20 characters
     * sell price formatted to 2 decimal places
     * @return 
     */
    public String toString(){
        
        /* if name is greater than 20 characters,
        characters 18, 19 and 20 become ellipses(...),
        subsequent characters are discarded*/
        if (name.length() > 20){
            String newName = "";          
            for (int i = 0; i < 17; i++){
                newName += name.charAt(i);
            }           
            name = newName + "...";
        }
        return String.format("%s (%s), QOH: %d Price: $%.2f",
                id, name, qoh, sellPrice);              
    }
}