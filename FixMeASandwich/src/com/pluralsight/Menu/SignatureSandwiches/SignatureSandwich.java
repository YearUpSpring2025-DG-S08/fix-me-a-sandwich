package com.pluralsight.Menu.SignatureSandwiches;
import com.pluralsight.Menu.Original.Sandwich;
import com.pluralsight.Menu.Original.Topping;


import java.util.ArrayList;
import java.util.List;

abstract class SignatureSandwich extends Sandwich {

    public SignatureSandwich(String breadType, int size, boolean isToasted) {
        super(breadType, size, isToasted);
    }

    protected List<Topping> originalToppings = new ArrayList<>();

    protected abstract List<Topping> prepDefaultToppings();
    
    
    public void resetToDefault(){
        this.toppings = new ArrayList<>(originalToppings);
    }

    @Override
    public List<Topping> getDefaultToppings() {
        return originalToppings;
    }
}
