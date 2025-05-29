package com.pluralsight.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
A Sandwich will be added to a Customer
The Sandwich will handle the heavy lifting: pulling together the Toppings and the Sides
getting a price for itself to be applied to the Customer
 */
public class Sandwich implements OrderItem {
    // instance variables
    //private double price; // S: 5.50 / M: 7.00 / L: 8.50
    private final String breadType;
    public int size;
    public final List<Topping> toppings = new ArrayList<>();
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
    
//    public Topping addMeat(String toppingName, boolean addExtra){
//        
//        Topping meatTopping = new Topping(toppingName, addExtra, true, true);
//        toppings.add(meatTopping);
//        return meatTopping;
//    }
//    
//    public Topping addCheese(String cheese, boolean addExtra){
//        
//        Topping cheeseTopping = new Topping(cheese, addExtra, true, false);
//        toppings.add(cheeseTopping);
//        return cheeseTopping;
//    }
//    
//    public Topping addRegularTopping(String topping, boolean addExtra){
//        
//        Topping regularTopping = new Topping(topping, addExtra, false, false);
//        toppings.add(regularTopping);
//        return regularTopping;
//    }
//
//    public Topping addSauce(String topping, boolean addExtra){
//        
//        Topping sauceTopping = new Topping(topping, addExtra, false, false);
//        toppings.add(sauceTopping);
//        return sauceTopping;
//    }
//    
//    public List<Topping> 
    // getters for the toppings
    
    @Override
    public double orderItemPrice() {
        double sandwichPrice = 0;
        // derived methods
            // uses the size and toppings to determine the price
            // create a derived method that will alter the basePrice based off sandwich size (+1)
            if (getSize() == 4) {
                sandwichPrice = 5.50;
            } else if (getSize() == 8) {
                sandwichPrice = 7;
            } else if (getSize() == 12) {
                sandwichPrice = 8.50;
            }

            //loop through all toppings, add price to total
            for(Topping t : this.toppings){
                sandwichPrice += t.getPrice(this.size);
            }

            return sandwichPrice;
        }

    @Override
    public String orderItemDescription() {
        String toppingsList = toppings.stream()
                .map(Topping::toString)
                .collect(Collectors.joining(", "));
        
        if(toppingsList.isEmpty()){
            System.out.println("No Toppings");
        }
        
        
        String currentSandwichOrder = String.format("Your current sandwich order is: \n" +
                "Sandwich Size: %s inches\n" +
                "Sandwich Bread: %s\n" +
                "Toppings: %s\n" +
                "Got Toasted?: %s\n" +
                "Sandwich Price: ", size, breadType, toppingsList, isToasted);
        return currentSandwichOrder;
    }
    
    
}
