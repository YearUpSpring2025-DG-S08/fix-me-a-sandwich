package com.pluralsight.Menu.SignatureSandwiches;

import com.pluralsight.Menu.Sandwich;
import com.pluralsight.Menu.Topping;

import java.util.ArrayList;
import java.util.List;

public class BLT extends Sandwich {
    private final String sandwichName = "BLT";
    public List <Topping> signatureToppings = new ArrayList<>();
    public Sandwich BLT;

    public BLT() {
        super("White", 8, true);
    }

    public String getSandwichName() {
        return sandwichName;
    }

    public List<Topping> getSignatureToppings() {
        signatureToppings.add(new Topping("Bacon", false, true, true));
        signatureToppings.add(new Topping("Cheddar", false, true, false));
        signatureToppings.add(new Topping("Lettuce", false, false, false));
        signatureToppings.add(new Topping("Tomato", false, false, false));
        signatureToppings.add(new Topping("Ranch", false, false, false));
        
        return signatureToppings;
    }

    public void setSignatureToppings(List<Topping> signatureToppings) {
        this.signatureToppings = signatureToppings;
    }

    public Sandwich getBLT() {
        return BLT;
    }
}
