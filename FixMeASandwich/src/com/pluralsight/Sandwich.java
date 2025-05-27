package com.pluralsight;

import java.util.List;

/*
A Sandwich will be added to a Customer
The Sandwich will handle the heavy lifting: pulling together the Toppings and the Sides
getting a price for itself to be applied to the Customer
 */
public class Sandwich implements OrderItem {
    // instance variables
    private double price;
    private String breadType;
    private  int size;
    private List<Topping> toppings;
    private String sauce;
    private boolean isToasted;

    // constructor
    public Sandwich(double price, String breadType, int size, String sauce, boolean isToasted) {
        this.price = price;
        this.breadType = breadType;
        this.size = size;
        this.sauce = sauce;
        this.isToasted = isToasted;
    }
    
    // getters & setters
    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }
    
    public Topping addMeat(String meat, boolean addExtra, boolean isPremium, boolean isMeat){
        if(getSize() == 4){
            price = 1;

            for(Topping topping : toppings){
                if(topping.addExtra()) {
                    price += .50;
                }
            }
        }

        if(getSize() == 8){
            price = 2;
            
            for(Topping topping : toppings){
                if(topping.addExtra()) {
                    price += 1;
                }
            }
        }

        if(getSize() == 12){
            price = 3;
                for(Topping topping : toppings){
                    if(topping.addExtra()) {
                        price += 1.50;
                    }
                }
        }
        
        return new Topping(meat, addExtra, isPremium, isMeat); 
    }
    
    private Topping addCheese(String cheese, boolean addExtra, boolean isPremium, boolean isMeat){
        if(getSize() == 4){
            price = .75;

            for(Topping topping : toppings){
                if(topping.addExtra()) {
                    price += .30;
                }
            }
        }

        if(getSize() == 8){
            price = 1.50;

            for(Topping topping : toppings){
                if(topping.addExtra()) {
                    price += .60;
                }
            }
        }

        if(getSize() == 12){
            price = 2.25;
            for(Topping topping : toppings){
                if(topping.addExtra()) {
                    price += .90;
                }
            }
        }
        return new Topping(cheese, addExtra, isPremium, isMeat);
    }
    
    private Topping addRegularTopping(String topping, boolean addExtra, boolean isPremium, boolean isMeat){
        price = 0;
        return new Topping(topping, addExtra, isPremium, isMeat);
    }

    private Topping addSauce(String topping, boolean addExtra, boolean isPremium, boolean isMeat){
        price = 0;
        return new Topping(topping, addExtra, isPremium, isMeat);
    }

    @Override
    public double getPrice() {
        // derived methods
            // uses the size and toppings to determine the price
            // create a derived method that will alter the basePrice based off sandwich size (+1)
            if (getSize() == 4) {
                price = 5.50;
                
            }
            if (getSize() == 8) {
                return price = 7;
            }
            if (getSize() == 12) {
                return price = 8.50;
            }
            return price;
        }

    @Override
    public String getDescription() {
        return "";
    }
}
