package com.pluralsight.Menu.Original;
/*
a Sandwich will have different toppings
Each topping will have its own price
Each topping will determine if there is extra toppings and adjust the price accordingly
Each topping will determine if it is premium and a meat
 */

public class Topping {
    private String name;
    private final boolean addExtra;
    private final boolean isPremium;
    private final boolean isMeat;
    double toppingPrice;

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
        if(sandwichSize== 4) {
            toppingPrice = 1;
            
            if(addExtra) {
                return toppingPrice += .50;
            }
        }
        

        if(sandwichSize == 8) {
            toppingPrice = 2;
            
            if(addExtra) {
                return toppingPrice += 1;
            }
        }
        

        if(sandwichSize == 12) {
            toppingPrice = 3;
            
            if (addExtra) {
                return toppingPrice += 1.50;
            }
        }
        
        return toppingPrice;
    }

    private double getCheesePrice(int sandwichSize){
        if(sandwichSize == 4) {
             toppingPrice = .75;
             
            if (addExtra) {
                return toppingPrice += .30;
            }
        }

        if(sandwichSize == 8){
            toppingPrice = 1.50;

            if (addExtra) {
                return toppingPrice += .60;
            }
        }

        if(sandwichSize == 12) {
            toppingPrice = 2.25;
            if (addExtra) {
                return toppingPrice += .90;
            }
        }
        return toppingPrice;
    }
    
    public String display(int size){
        toppingPrice = getPrice(size);


        String confirmExtra = addExtra ? "(extra)" : "";

        return String.format("%s%s: $%.2f", name, confirmExtra, toppingPrice);
        
        
    }
}
