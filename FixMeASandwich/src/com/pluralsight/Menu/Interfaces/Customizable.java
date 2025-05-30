package com.pluralsight.Menu.Interfaces;

import com.pluralsight.Menu.Original.Topping;

import java.util.List;

// created because of Signature sandwich, however could be used for regular sandwich if necessary
public interface Customizable {
    public void resetToDefault();
    public List<Topping> getDefaultToppings();
}
