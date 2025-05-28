package com.pluralsight;

public class Drink implements OrderItem{
    private String drinkFlavor;
    private String drinkSize;
    private double drinkPrice;

    public Drink(String drinkFlavor) {
        this.drinkFlavor = drinkFlavor;
        this.drinkPrice = drinkPrice;
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

    public void setDrinkSize(String drinkSize) {
        if(drinkSize.equalsIgnoreCase("Small")){
            drinkSize = "Small";
        } else if(drinkSize.equalsIgnoreCase("Medium")){
            drinkSize = "Medium";
        } else{
            drinkSize = "Large";
        }
    }

    public double getDrinkPrice() {
        if(drinkSize.equalsIgnoreCase("Small")){
            return drinkPrice = 2;
        } else if(drinkSize.equalsIgnoreCase("Medium")){
            return drinkPrice = 2.50;
        } else{
            return drinkPrice = 3;
        }
    }

    @Override
    public String orderItemDescription() {
        return String.format("%s %s", drinkSize, drinkFlavor);
    }

    @Override
    public double orderItemPrice() {
        if(drinkSize.equalsIgnoreCase("Small")){
            return drinkPrice = 2;
        } else if(drinkSize.equalsIgnoreCase("Medium")){
            return drinkPrice = 2.50;
        } else{
            return drinkPrice = 3;
        }
    }
}
