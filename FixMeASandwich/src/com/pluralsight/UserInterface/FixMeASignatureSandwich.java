package com.pluralsight.UserInterface;

import com.pluralsight.Menu.Original.Sandwich;
import com.pluralsight.Menu.SignatureSandwiches.BLT;
import com.pluralsight.Menu.SignatureSandwiches.Cuban;
import com.pluralsight.Menu.SignatureSandwiches.PhillyCheeseSteak;
import com.pluralsight.Menu.SignatureSandwiches.TheDiamond;
import com.pluralsight.Menu.Original.Topping;
import java.util.List;

public class FixMeASignatureSandwich {
    private static final Console console = new Console();
    
    // signature sandwich customization menu
    public Sandwich customizeSignatureSandwich() {
        String chooseSignatureSandwich = console.promptForString("""
                Which signature sandwich will fix you up?
                [1] BLT
                [2] Cuban
                [3] Philly Cheese Steak
                [4] "The Diamond"
                """);

        switch (chooseSignatureSandwich) {
            case "1" -> {
                BLT blt = new BLT();
                confirmSandwichCustomization(blt);
                return blt;
            }
            case "2" -> {
                Cuban cuban = new Cuban();
                confirmSandwichCustomization(cuban);
                return cuban;
            }
            case "3" -> {
                PhillyCheeseSteak cheeseSteak = new PhillyCheeseSteak();
                confirmSandwichCustomization(cheeseSteak);
                return cheeseSteak;
            }
            case "4" -> {
                TheDiamond theDiamond = new TheDiamond();
                confirmSandwichCustomization(theDiamond);
                return theDiamond;
            }
            default -> System.out.println("Invalid Input. Please Try Again");
        }
        
        return null;
    }
    
    public void confirmSandwichCustomization(Sandwich signatureSandwich){
        Topping sigToppings = getToppingsFromSignatureSandwiches(signatureSandwich);
        String removableTopping = sigToppings != null ? sigToppings.getName() : null;
        signatureSandwich.orderItemDescription();
        
        String removeToppings = console.promptForString("""
                Would you like to add or remove any toppings?
                [1] Add
                [2] Remove
                [3] Confirm Order
                """);
        
        switch (removeToppings){
            case "1" -> addToppingsToSandwich(signatureSandwich.toppings);
            case "2" -> removeToppingsFromSandwich(removableTopping);
            case "3" -> OrderScreen.showCheckoutScreen();
            default -> System.out.println("Invalid Input. Please Try Again");
        }
    }
    
    private void addToppingsToSandwich(List<Topping> signatureToppings){
        // this method needs to take the toppings of the chosen signature sandwich and
        // allowing the user to add more
        FixMeABasicSandwich.chooseToppings();
        for(Topping sigTopping : signatureToppings){
            OrderScreen.sandwich.toppings.add(sigTopping);
        }
        
//        OrderScreen.sandwich.toppings.addAll(signatureToppings);
    }
    
    private void removeToppingsFromSandwich(String toppingName){
        // this method will take a topping the user enters
        // and matches the topping name to remove
        OrderScreen.sandwich.toppings.removeIf(signatureToppingName -> signatureToppingName.getName().contains(toppingName));
    }
    
    private Topping getToppingsFromSignatureSandwiches(Sandwich signatureSandwich){
        for(Topping topping : signatureSandwich.toppings){
            return topping;
        }
        return null;
    }
}
