package com.pluralsight.Menu.Original;

import com.pluralsight.Menu.Interfaces.Customizable;
import com.pluralsight.Menu.Interfaces.OrderItem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
A Sandwich will be added to a Customer
The Sandwich will handle the heavy lifting: pulling together the Toppings and the Sides
getting a price for itself to be applied to the Customer
 */
public class Sandwich implements OrderItem , Customizable {
    // instance variables
    //private double price; // S: 5.50 / M: 7.00 / L: 8.50
    private String breadType;
    public int size;
    public List<Topping> toppings = new ArrayList<>();
    private boolean isToasted;

    // constructor
    public Sandwich(String breadType, int size, boolean isToasted) {
        this.breadType = breadType;
        this.size = size;
        this.isToasted = isToasted;
    }
    
    public Sandwich(){}
    
    // getters & setters
    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings){
        this.toppings = toppings;
    }
    
    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public int getSize() {
        return size;
    }
    
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
            .map(topping -> topping.display(size))
            .collect(Collectors.joining(", "));

      if(toppingsList.isEmpty()){
          toppings.addAll(getToppings());
       }

        
        
        
        return String.format("""
                === Sandwich === \s
                Sandwich Size: %s inches
                Sandwich Bread: %s
                Toppings: %s
                Got Toasted?: %s
                Sandwich Price: $%.2f\s""", size, breadType, toppingsList, isToasted, orderItemPrice());
    }


    @Override
    public void resetToDefault() {
        this.toppings = new ArrayList<>(toppings);
    }

    @Override
    public List<Topping> getDefaultToppings() {
        return new ArrayList<>(toppings);
    }
}
