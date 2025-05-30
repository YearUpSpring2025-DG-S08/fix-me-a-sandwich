package com.pluralsight.UserInterface;

import com.pluralsight.Menu.Original.Sandwich;
import com.pluralsight.Menu.Original.Topping;
import com.pluralsight.Menu.SignatureSandwiches.BLT;
import com.pluralsight.Menu.SignatureSandwiches.Cuban;
import com.pluralsight.Menu.SignatureSandwiches.PhillyCheeseSteak;
import com.pluralsight.Menu.SignatureSandwiches.TheDiamond;

import java.util.ArrayList;
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
        String originalToppingList = signatureSandwich.getDefaultToppings().stream()
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
            case "1" -> addToppingsToSandwich(signatureSandwich);
            case "2" -> removeToppingsFromSandwich(signatureSandwich);
            case "3" -> OrderScreen.showCheckoutScreen();
            default -> System.out.println("Invalid Input. Please Try Again");
        }
    }
    
    private void addToppingsToSandwich(Sandwich signatureSandwich){
        // this method needs to take the toppings of the chosen signature sandwich and
        // allowing the user to add more
        FixMeABasicSandwich.chooseToppings();
        signatureSandwich.getDefaultToppings().addAll(OrderScreen.sandwich.toppings);
    }
    
    private List<Topping> removeToppingsFromSandwich(Sandwich signatureSandwich){
        // this method will take a topping the user enters
        // and matches the topping name to remove
        List<Topping> toppingsToRemove = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display current toppings
            System.out.println("\n=== Current Toppings ===");
            if (signatureSandwich.toppings.isEmpty()) {
                System.out.println("No toppings on the sandwich.");
                break;
            }

            for (int i = 0; i < signatureSandwich.toppings.size(); i++) {
                System.out.println((i + 1) + ". " + signatureSandwich.toppings.get(i).getName());
            }
            
            System.out.println("0. Done removing toppings");
            System.out.print("Select a topping to remove (enter number): ");

            int choice = scanner.nextInt();

            if (choice == 0) {
                break;
            } else if (choice > 0 && choice <= signatureSandwich.toppings.size()) {
                Topping removedTopping = signatureSandwich.toppings.remove(choice - 1);
                toppingsToRemove.add(removedTopping);
                System.out.println("Removed: " + removedTopping.getName());
            } else {
                System.out.println("Invalid selection. Please try again.");
            }
        }

        return toppingsToRemove;
    }
}
