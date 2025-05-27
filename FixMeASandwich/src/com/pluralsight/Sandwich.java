package com.pluralsight;
/*
A Sandwich will be added to a Customer
The Sandwich will handle the heavy lifting: pulling together the Toppings and the Sides
getting a price for itself to be applied to the Customer
 */
public class Sandwich {
    // instance variables
    private String breadType;
    private  int size;
    private Topping toppings;
    private String sauce;
    private boolean isToasted;

    // constructor
    public Sandwich(String breadType, int size, Topping toppings, boolean isToasted) {
        this.breadType = breadType;
        this.size = size;
        this.toppings = toppings;
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

    public Topping getToppings() {
        return toppings;
    }

    public void setToppings(Topping toppings) {
        this.toppings = toppings;
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
    
    // derived methods
    private void getPrice() {
        // uses the size and toppings to determine the price
    }
    
    private void addToOrder(){
        // takes the existing receipt for a customer order and adds itself onto the receipt to be recorded
    }
}
