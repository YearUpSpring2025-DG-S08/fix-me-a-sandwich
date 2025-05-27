package com.pluralsight;

/*
a Sandwich will have different toppings
Each topping will have its own price
Each topping will determine if there is extra toppings and adjust the price accordingly
 */

public abstract class Topping {
    private String name;
    private double price;
    private boolean addExtra;

    public Topping(String name, double price, boolean addExtra) {
        this.name = name;
        this.price = price;
        this.addExtra = addExtra;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean addExtra() {
        return addExtra;
    }

    public void setAddExtra(boolean addExtra) {
        this.addExtra = addExtra;
    }
}
