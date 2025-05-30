package com.pluralsight.Menu.SignatureSandwiches;

import com.pluralsight.Menu.Original.Sandwich;
import com.pluralsight.Menu.Original.Topping;

import java.util.ArrayList;
import java.util.List;

public class TheDiamond extends SignatureSandwich {
    public Sandwich TheDiamond;

    public TheDiamond() {
        super("French Baguette", 12, true);
        setSignatureToppings();
        resetToDefault();
    }

    public String getSandwichName() {
        return "The Diamond";
    }

    public List<Topping> setSignatureToppings() {
        signatureToppings.add(new Topping("Mozzarella", false, true, false));
        signatureToppings.add(new Topping("Lettuce", false, false, false));
        signatureToppings.add(new Topping("Red Onion", false, false, false));
        signatureToppings.add(new Topping("Salt", false, false, false));
        signatureToppings.add(new Topping("Pepper", false, false, false));
        signatureToppings.add(new Topping("Oregano", false, false, false));
        signatureToppings.add(new Topping("Mayo", false, false, false));

        return signatureToppings;
    }

    public void setSignatureToppings(List<Topping> signatureToppings) {
        this.signatureToppings = signatureToppings;
    }

    public Sandwich getTheDiamond() {
        return TheDiamond;
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
