package com.pluralsight.Menu.SignatureSandwiches;
import com.pluralsight.Menu.Original.Sandwich;
import com.pluralsight.Menu.Original.Topping;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// abstract class was necessary due to nature of signature sandwiches having original toppings
// naturally extends sandwich which allow it to inherit from OrderItem and Customizable
abstract class SignatureSandwich extends Sandwich {

    // the toppings that come on each signature sandwich must be initialized for user
    // ensures that signature sandwich list of toppings is not null and can be added/removed
    public SignatureSandwich(String breadType, int size, boolean isToasted) {
        super(breadType, size, isToasted);
        getOriginalToppings();
    }

    private void getOriginalToppings(){
        List<Topping> originalToppings = prepDefaultToppings();
        this.originalToppings = new ArrayList<>(originalToppings);
        this.toppings = new ArrayList<>(originalToppings);
    }
    
    protected List<Topping> originalToppings = new ArrayList<>();

    protected abstract List<Topping> prepDefaultToppings();
    
    
    public void resetToDefault(){
        this.toppings = new ArrayList<>(originalToppings);
    }

    @Override
    public List<Topping> getDefaultToppings() {
        return new ArrayList<>(originalToppings);
    }

    @Override
    public String orderItemDescription() {

        String toppingsList = originalToppings.stream()
                .map(topping -> topping.display(size))
                .collect(Collectors.joining(", "));

        if(toppingsList.isEmpty()){
            toppings.addAll(getToppings());
        }




        return String.format("""
                === Sandwich === \s
                Sandwich Size: %s inches
                Sandwich Bread: %s
                Toppings: %s
                Got Toasted?: %s
                Sandwich Price: $%.2f\s""", size, this.getBreadType(), this.getToppings(), this.isToasted(), this.orderItemPrice());
    }
}
