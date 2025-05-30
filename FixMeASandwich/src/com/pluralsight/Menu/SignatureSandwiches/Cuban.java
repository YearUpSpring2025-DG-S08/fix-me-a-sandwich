package com.pluralsight.Menu.SignatureSandwiches;

import com.pluralsight.Menu.Original.Sandwich;
import com.pluralsight.Menu.Original.Topping;

import java.util.ArrayList;
import java.util.List;

public class Cuban extends SignatureSandwich {
    public List <Topping> signatureToppings = new ArrayList<>();
    public Sandwich Cuban;

    public Cuban() {
        super("Cuban Bread", 8, true);
        getDefaultToppings();
    }

    public String getSandwichName() {
        return "Cuban";
    }

    public List<Topping> getSignatureToppings() {
        signatureToppings.add(new Topping("Roasted Pork", false, true, true));
        signatureToppings.add(new Topping("Ham", false, true, true));
        signatureToppings.add(new Topping("Swiss Cheese", false, true, false));
        signatureToppings.add(new Topping("Pickles", false, false, false));
        signatureToppings.add(new Topping("Mustard", false, false, false));

        return signatureToppings;
    }

    public void setSignatureToppings(List<Topping> signatureToppings) {
        this.signatureToppings = signatureToppings;
    }

    public Sandwich getCuban() {
        return Cuban;
    }

    @Override
    public List<Topping> getDefaultToppings() {
        return getSignatureToppings();
    }
}
