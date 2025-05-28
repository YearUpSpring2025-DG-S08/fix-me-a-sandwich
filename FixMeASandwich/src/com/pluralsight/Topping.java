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
    double toppingPrice = 0;

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
    
//     helper methods that will be called by the Sandwich class to add up the price of the sandwich
//     and the toppings
    public double getPrice(int sandwichSize){
        if(this.isPremium){
            if(this.isMeat){
                return getMeatPrice(sandwichSize);
            }
            else {
                return getCheesePrice(sandwichSize);
            }
        }
        
        return toppingPrice;
    }
    
    private double getMeatPrice(int sandwichSize){
        if(sandwichSize == 4) {
            return toppingPrice = 1;
        }
        
        if(addExtra) {
            return toppingPrice += .50;
        }

        if(sandwichSize == 8) {
            toppingPrice = 2;
        }
        
        if(addExtra) {
            return toppingPrice += 1;
        }

        if(sandwichSize == 12) {
            toppingPrice = 3;
        }

        if (addExtra) {
            return toppingPrice += 1.50;
        }
        
        return toppingPrice;
    }

    private double getCheesePrice(int sandwichSize){
        if(sandwichSize == 4) {
            return toppingPrice = .75;
            }
            if (addExtra) {
                return toppingPrice += .30;
            }

        if(sandwichSize == 8){
            toppingPrice = 1.50;

            if (addExtra) {
                return toppingPrice += .60;
            }
        }

        if (addExtra) {
            return toppingPrice += .90;
        }
        return toppingPrice;
    }
}
