package com.pluralsight.Menu.SignatureSandwiches;

// necessary imports to access class methods from different packages
// creating instances of each object did not seem appropriate
import com.pluralsight.Menu.Original.Sandwich;
import com.pluralsight.Menu.Original.Topping;

import java.util.ArrayList;
import java.util.List;

// each subclass of Signature Sandwich will have their own set of predetermined toppings
// as well as a predetermine bread type, size, and boolean value which can be changed by the user
public class BLT extends SignatureSandwich {

    public BLT() {
        super("White", 8, true);
        setSignatureToppings();
        resetToDefault();
    }

    public String getSandwichName() {
        return "BLT";
    }
    

    public void setSignatureToppings() {
        signatureToppings.add(new Topping("Bacon", false, true, true));
        signatureToppings.add(new Topping("Cheddar", false, true, false));
        signatureToppings.add(new Topping("Lettuce", false, false, false));
        signatureToppings.add(new Topping("Tomato", false, false, false));
        signatureToppings.add(new Topping("Ranch", false, false, false));
    }
    
    @Override
    public void resetToDefault() {
        this.toppings = new ArrayList<>(signatureToppings);
    }

    @Override
    public List<Topping> getDefaultToppings() {
        return signatureToppings;
    }

}
