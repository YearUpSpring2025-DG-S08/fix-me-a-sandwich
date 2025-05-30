package com.pluralsight.Menu.SignatureSandwiches;

import com.pluralsight.Menu.Original.Sandwich;
import com.pluralsight.Menu.Original.Topping;

import java.util.ArrayList;
import java.util.List;

public class TheDiamond extends SignatureSandwich {
    private final String sandwichName = "The Diamond";
    public List <Topping> signatureToppings = new ArrayList<>();
    public Sandwich TheDiamond;

    public TheDiamond() {
        super("French Baguette", 12, true);
        this.signatureToppings = getSignatureToppings();
    }

    public String getSandwichName() {
        return sandwichName;
    }

    public List<Topping> getSignatureToppings() {
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
    protected List<Topping> prepDefaultToppings() {
        return getSignatureToppings();
    }
}
