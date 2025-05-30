package com.pluralsight.Menu.SignatureSandwiches;
import com.pluralsight.Menu.Original.Sandwich;
import com.pluralsight.Menu.Original.Topping;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// abstract class was necessary due to nature of signature sandwiches having original toppings
// naturally extends sandwich which allow it to inherit from OrderItem and Customizable
abstract class SignatureSandwich extends Sandwich {
    protected List<Topping> signatureToppings;
    
    // the toppings that come on each signature sandwich must be initialized for user
    // ensures that signature sandwich list of toppings is not null and can be added/removed
    public SignatureSandwich(String breadType, int size, boolean isToasted) {
        super(breadType, size, isToasted);
        this.signatureToppings = new ArrayList<>();
    }
    
    
    
    public void resetToDefault(){
        this.toppings = new ArrayList<>(signatureToppings);
    }

    @Override
    public List<Topping> getDefaultToppings() {
        return new ArrayList<>(signatureToppings);
    }

    @Override
    public String orderItemDescription() {
        if(signatureToppings.isEmpty()){
            System.out.println("This list is empty");
        } else{
            System.out.println("there are toppings in this list");
        }
        
        
        String toppingsList = signatureToppings.stream()
                .map(topping -> topping.display(this.size))
                .collect(Collectors.joining(", "));




        return String.format("""
                === Sandwich === \s
                Sandwich Size: %s inches
                Sandwich Bread: %s
                Toppings: %s
                Got Toasted?: %s
                Sandwich Price: $%.2f\s""", this.size, this.getBreadType(), toppingsList, this.isToasted(), this.orderItemPrice());
    }
}
