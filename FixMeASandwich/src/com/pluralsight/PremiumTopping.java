package com.pluralsight;

public class PremiumTopping extends Topping {
    public PremiumTopping(String name, double price, boolean addExtra) {
        super(name, price, addExtra);
    }

    // create a derived method that will alter the basePrice based off sandwich size (+1)
    // create a derived method that will alter the basePrice based off addExtra = true; (+.50)
    @Override
    public void setPrice(double price) {
    }

    private double calculatePrice(Sandwich sandwich){
    if(sandwich.getSize() == 4){
        return super.getPrice() +  
    }
    
        return 0;
    }
}
