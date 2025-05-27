package com.pluralsight;

/*
a Sandwich will have different toppings
Each topping will have its own price
Each topping will determine if there is extra toppings and adjust the price accordingly
Each topping will determine if it is premium and a meat
 */

public class Topping {
    private String name;
    private boolean addExtra;
    private boolean isPremium;
    private boolean isMeat;

    public Topping(String name, boolean addExtra, boolean isPremium, boolean isMeat) {
        this.name = name;
        this.addExtra = addExtra;
        this.isPremium = isPremium;
        this.isMeat = isMeat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean addExtra() {
        return addExtra;
    }

    public void setAddExtra(boolean addExtra) {
        this.addExtra = addExtra;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public boolean isMeat() {
        return isMeat;
    }

    public void confirmMeatTopping(boolean meat) {
        isMeat = meat;
    }
}
