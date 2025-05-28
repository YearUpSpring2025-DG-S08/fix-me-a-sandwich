package com.pluralsight;

import java.util.List;

/*
A Sandwich will be added to a Customer
The Sandwich will handle the heavy lifting: pulling together the Toppings and the Sides
getting a price for itself to be applied to the Customer
 */
public class Sandwich implements OrderItem {
    // instance variables
    //private double price; // S: 5.50 / M: 7.00 / L: 8.50
    private final String breadType;
    private  int size;
    private List<Topping> toppings;
    private final boolean isToasted;

    // constructor
    public Sandwich(String breadType, int size, boolean isToasted) {
        this.breadType = breadType;
        this.size = size;
        this.isToasted = isToasted;
    }
    
    // getters & setters
    public String getBreadType() {
        return breadType;
    }
    
    public int getSize() {
        return size;
    }

    public List<Topping> getToppings() {
        return toppings;
    }
    

    public boolean isToasted() {
        return isToasted;
    }
    
    public Topping addMeat(String toppingName, boolean addExtra){
        
        Topping meatTopping = new Topping(toppingName, addExtra, true, true);
        toppings.add(meatTopping);
        return meatTopping;
    }
    
    private Topping addCheese(String cheese, boolean addExtra){
        
        Topping cheeseTopping = new Topping(cheese, addExtra, true, false);
        toppings.add(cheeseTopping);
        return cheeseTopping;
    }
    
    private Topping addRegularTopping(String topping, boolean addExtra, boolean isPremium, boolean isMeat){
        
        Topping regularTopping = new Topping(topping, addExtra, isPremium, isMeat);
        toppings.add(regularTopping);
        return regularTopping;
    }

    private Topping addSauce(String topping, boolean addExtra, boolean isPremium, boolean isMeat){
        
        Topping sauceTopping = new Topping(topping, addExtra, isPremium, isMeat);
        toppings.add(sauceTopping);
        return sauceTopping;
    }
    
    @Override
    public String orderItemDescription() {
        return "This contains the description of the sandwich";
    }
    
    @Override
    public double orderItemPrice() {
        double sandwichPrice = 0;
        // derived methods
            // uses the size and toppings to determine the price
            // create a derived method that will alter the basePrice based off sandwich size (+1)
            if (getSize() == 4) {
                sandwichPrice = 5.50;
                
            }
            if (getSize() == 8) {
                return sandwichPrice = 7;
            }
            if (getSize() == 12) {
                return sandwichPrice = 8.50;
            }
            
            //loop through all toppings, add price to total
        
            for(Topping t : this.toppings){
                sandwichPrice += t.getPrice(this.size);
            }
            
            return sandwichPrice;
        }
}
