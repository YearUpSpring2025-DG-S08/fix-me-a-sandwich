package com.pluralsight.Menu.SignatureSandwiches;

import com.pluralsight.Menu.Original.Sandwich;
import com.pluralsight.Menu.Original.Topping;

import java.util.ArrayList;
import java.util.List;

public class PhillyCheeseSteak extends SignatureSandwich {
    public Sandwich CheeseSteak;

    public PhillyCheeseSteak() {
        super("White", 8, true);
        setSignatureToppings();
        resetToDefault();
    }

    public String getSandwichName() {
        return "Philly Cheese Steak";
    }

    public List<Topping> setSignatureToppings() {
        signatureToppings.add(new Topping("Steak", false, true, true));
        signatureToppings.add(new Topping("American Cheese", false, true, false));
        signatureToppings.add(new Topping("Peppers", false, false, false));
        signatureToppings.add(new Topping("Mayo", false, false, false));

        return signatureToppings;
    }

    public void setSignatureToppings(List<Topping> signatureToppings) {
        this.signatureToppings = signatureToppings;
    }

    public Sandwich getCheeseSteak() {
        return CheeseSteak;
    }

    @Override
    public List<Topping> getDefaultToppings() {
        return signatureToppings;
    }

    @Override
    public void resetToDefault() {
        this.toppings = new ArrayList<>(signatureToppings);
    }
}
