package com.pluralsight.Menu.SignatureSandwiches;

import com.pluralsight.Menu.Original.Sandwich;
import com.pluralsight.Menu.Original.Topping;

import java.util.ArrayList;
import java.util.List;

public class PhillyCheeseSteak extends SignatureSandwich {
    private final String sandwichName = "Philly Cheese Steak";
    public List <Topping> signatureToppings = new ArrayList<>();
    public Sandwich CheeseSteak;

    public PhillyCheeseSteak() {
        super("White", 8, true);
        this.signatureToppings = prepDefaultToppings();
    }

    public String getSandwichName() {
        return sandwichName;
    }

    public List<Topping> getSignatureToppings() {
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
    protected List<Topping> prepDefaultToppings() {
        return getSignatureToppings();
    }
}
