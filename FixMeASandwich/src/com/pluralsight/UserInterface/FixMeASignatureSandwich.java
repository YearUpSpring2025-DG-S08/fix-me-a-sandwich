package com.pluralsight.UserInterface;

import com.pluralsight.Menu.Original.Sandwich;
import com.pluralsight.Menu.Original.Topping;
import com.pluralsight.Menu.SignatureSandwiches.BLT;
import com.pluralsight.Menu.SignatureSandwiches.Cuban;
import com.pluralsight.Menu.SignatureSandwiches.PhillyCheeseSteak;
import com.pluralsight.Menu.SignatureSandwiches.TheDiamond;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// separated the logic of creating a signature sandwich due to the nature of a signature sandwich
// each method is focused on customization of the sandwich
// still experiencing errors with null values in list
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

        return switch (chooseSignatureSandwich) {
            case "1" -> buildSignatureSandwich(new BLT());
            case "2" -> buildSignatureSandwich(new Cuban());
            case "3" -> buildSignatureSandwich(new PhillyCheeseSteak());
            case "4" -> buildSignatureSandwich(new TheDiamond());
            default -> {
                System.out.println("Invalid Input. Please Try Again");
                yield customizeSignatureSandwich(); // Recursively call until valid input
            }
        };
    }

    public Sandwich confirmSandwichCustomization(Sandwich signatureSandwich){
        String originalToppingList = signatureSandwich.toppings.stream()
                .map(match -> match.display(signatureSandwich.size))
                .collect(Collectors.joining("\n"));

        System.out.println(originalToppingList);

        String customizeToppings = console.promptForString("""
                Would you like to add or remove any toppings?
                [1] Add
                [2] Remove
                [3] Confirm Order
                """);

        switch (customizeToppings){
            case "1" -> {
                addToppingsToSandwich(signatureSandwich);
                return confirmSandwichCustomization(signatureSandwich); // Continue customization
            }
            case "2" -> {
                removeToppingsFromSandwich(signatureSandwich);
                return confirmSandwichCustomization(signatureSandwich); // Continue customization
            }
            case "3" -> {
                return signatureSandwich; // Return the customized sandwich
            }
            default -> {
                System.out.println("Invalid Input. Please Try Again");
                return confirmSandwichCustomization(signatureSandwich); // Try again
            }
        }
    }

    private void addToppingsToSandwich(Sandwich signatureSandwich) {
        System.out.println("\n=== Add Extra Toppings ===");

        // the main method used to choose toppings relies on the sandwich order from within Order Screen
        // saving original sandwich to reduce any errors from other usage cases
        Sandwich saveBasicSandwich = OrderScreen.sandwich;


        // temporarily saving this variable allows the user to add toppings to the signature sandwich
        OrderScreen.sandwich = signatureSandwich;

        // use existing method to choose toppings while the Order Screen sandwich is saved to the signature sandwich
        FixMeABasicSandwich.chooseToppings();

        // after completing the topping addition - returning order screen sandwich back to the basic sandwich
        // to reduce any errors in other parts of the code that use its sandwich methods
        if (saveBasicSandwich != null) {
            OrderScreen.sandwich = saveBasicSandwich;
        } else {
            System.out.println("There is no sandwich to save");
        }
    }

    private void removeToppingsFromSandwich(Sandwich signatureSandwich){
        // this method will take a topping the user enters
        // and matches the topping name to remove
        System.out.println("List size: " + signatureSandwich.toppings.size());

        List<Topping> toRemove = signatureSandwich.toppings.stream()
                .filter(topping -> {
                    System.out.println("Remove " + topping.getName() + "? (y/n): ");
                    return new Scanner(System.in).nextLine().toLowerCase().startsWith("y");
                })
                .toList();

        // Then remove them safely
        signatureSandwich.toppings.removeAll(toRemove);
    }

    // helper method to create signature sandwich and initializing the array list of each sandwich
    private Sandwich buildSignatureSandwich(Sandwich signatureSandwiches) {
        signatureSandwiches.resetToDefault();
        confirmSandwichCustomization(signatureSandwiches);
        return signatureSandwiches;
    }
}
