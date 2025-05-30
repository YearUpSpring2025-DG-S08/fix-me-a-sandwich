package com.pluralsight.Menu.Interfaces;

import com.pluralsight.Menu.Original.Topping;

import java.util.List;

public interface Customizable {
    public void resetToDefault();
    public List<Topping> getDefaultToppings();
}
