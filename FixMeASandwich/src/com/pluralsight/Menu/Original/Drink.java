package com.pluralsight.Menu.Original;

import com.pluralsight.Menu.Interfaces.OrderItem;

public class Drink implements OrderItem {
    private String drinkFlavor;
    private final String drinkSize;

    public Drink(String drinkFlavor, String drinkSize) {
        this.drinkFlavor = drinkFlavor;
        this.drinkSize = drinkSize;
    }

    public String getDrinkFlavor() {
        return drinkFlavor;
    }

    public void setDrinkFlavor(String drinkFlavor) {
        this.drinkFlavor = drinkFlavor;
    }

    public String getDrinkSize() {
        return drinkSize;
    }

    @Override
    public String orderItemDescription() {
        return String.format("""
                \n 
                === Drink ===
                %s %s: $%.2f\n"""
                , drinkSize, drinkFlavor, orderItemPrice());
    }

    @Override
    public double orderItemPrice() {
        double drinkPrice;
        if(drinkSize.equalsIgnoreCase("Small")){
             drinkPrice = 2;
        } else if(drinkSize.equalsIgnoreCase("Medium")){
             drinkPrice = 2.50;
        } else{
             drinkPrice = 3;
        }
        
        return drinkPrice;
        }
    }
