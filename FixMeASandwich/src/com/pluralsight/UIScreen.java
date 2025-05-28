package com.pluralsight;

import java.util.List;

public class UIScreen {
    private static final Console console = new Console();
    private final Order order = new Order();
    
//    private void init(){
//        this.order = 
//    }
    
    // UIScreen display methods
    public void showHomeScreen() {

        System.out.println("""
                Welcome to Fix-Me-A-Sandwich!
                Where you can fully customize your sandwich to however you choose!""");

        String input = console.promptForString("Can I fix you a sandwich?: Y/N ");

        if (input.equalsIgnoreCase("Y")) {

            int sandwichSize = console.promptForInt("""
                    Please choose a sandwich size:
                    [1] 4" - "Fix me a 4 inch"
                    [2] 8" - "Fix me a 8 inch"
                    [3] 12" - "Fix me a 12 inch
                    """);

            String breadType = "";
            switch (sandwichSize) {
                case 1:
                    // prompt customers to choose toppings (create Topping object)
                    // to choose to toast their sandwich (boolean value true)
                    // add sides (create Chips/Drink object)
                    // confirm whether they want the order
                    System.out.println("You have chosen: " + sandwichSize);
                    breadType = customizeBread();
                    chooseToppings();
                    break;
                case 2:
                    System.out.println("You have chosen: " + sandwichSize);
                    breadType = customizeBread();
                    chooseToppings();
                    break;
                case 3:
                    System.out.println("You have chosen: " + sandwichSize);
                    breadType = customizeBread();
                    chooseToppings();
                    break;
            }

            String getToasted = console.promptForString("Would you like your sandwich toasted? Y/N ");
            boolean isToasted = getToasted.equalsIgnoreCase("Y");
            Sandwich sandwich = new Sandwich(breadType, sandwichSize, isToasted);
            
        } else {
            System.out.println("Thank you for coming to Fix-Me-A-Sandwich! Have a wonderful day!");
        }
        
        String addOnSides;
        do {
            addOnSides = console.promptForString("""
                    Would you like to add on some sides?
                    [1] Add a Drink
                    [2] Add some Chips
                    [0] Go to Checkout
                    [X] Cancel Order
                    """);

            switch (addOnSides) {
                case "1":
                    // go to method where a drink object is being created
                    customizeDrinkOrder();
                    break;
                case "2":
                    // go to method where a chips object is being created
                    customizeChipsOrder();
                    break;
                case "0":
                    // go to checkout screen
                    showCheckoutScreen();
                    break;
                case "X":
                    // confirm order cancellation
                    // make sure the order does not get saved into the file
                    String confirmCancellation = console.promptForString("Are you sure you want to cancel the order? Y/N ");

                    if (confirmCancellation.equalsIgnoreCase("Y")) {
                        System.out.println("Order has been cancelled!");
                        System.out.println("Thank you for coming to Fix-Me-A-Sandwich! Have a wonderful day!");
                    } else {
                        return;
                    }
                    break;
                default:
                    System.out.println("Invalid Input. Please Try Again");
                    break;
            }
        } while (!addOnSides.equalsIgnoreCase("X"));
    }
    
    private void showCheckoutScreen(){
        // this is where we will need to utilize the Order class
        // to present the Customer and the list of OrderItems
        showCompleteOrder(Order.orderItems);
    }
    
    // helper method
    private String customizeBread() {
        // prompt user to decide a bread choice
        String breadType = console.promptForString("""
                What type of bread do you want?:
                [1] Fix me some white
                [2] Fix me some wheat
                [3] Fix me some rye
                [4] Fix me a wrap
                """);

        switch (breadType) {
            case "1": breadType = "white"; break;
            case "2": breadType = "wheat"; break;
            case "3": breadType = "rye"; break;
            case "4": breadType = "wrap"; break;
            default: System.out.println("Invalid Input. Please Try Again."); break;
        }
        
        return breadType;
    }
    
    private void chooseToppings(){
        // prompt user to decide toppings
        String toppingType = console.promptForString("""
                Please choose your toppings:
                [1] Premium (meat/cheese)
                [2] Regular (other)
                """);

        if (toppingType.equals("1")) {
            customizePremiumToppings(toppingType);
        } else if (toppingType.equals("2")) {
            customizeRegularTopping(toppingType);
        }
        // prompt user to decide if they want to toast their sandwich
        // create a new Sandwich
    }

    private Topping customizePremiumToppings(String toppingType) {
        if (toppingType.equals("1")) {
            String premiumChoice = UIScreen.console.promptForString("""
                    What can we fix on your sandwich?
                    [1] Meat
                    [2] Cheese
                    """);

            if (premiumChoice.equals("1")) {
                String meatChoice;
                do {
                    meatChoice = console.promptForString("""
                            Pick your meat fixings:
                            [1] Steak
                            [2] Ham
                            [3] Salami
                            [4] Roast Beef
                            [5] Chicken
                            [6] Bacon
                            """);

                    switch (meatChoice) {
                        case "1": meatChoice = "Steak"; break;
                        case "2": meatChoice = "Ham"; break;
                        case "3": meatChoice = "Salami"; break;
                        case "4": meatChoice = "Roast Beef"; break;
                        case "5": meatChoice = "Chicken"; break;
                        case "6": meatChoice = "Bacon"; break;
                        default: System.out.println("Invalid meat choice. Please choose from the menu options."); break;
                    }

                            // prompt user to decide if they want extra toppings
                            boolean addExtraMeat;
                            String extraMeat = console.promptForString("Would you like an extra fixing? Y/N ");

                            addExtraMeat = extraMeat.equals("Y");

                            return new Topping(meatChoice, addExtraMeat, true, true);
                    } while (meatChoice != null);
                
            } else if (premiumChoice.equals("2")) {
                String cheeseChoice;
                do {
                    cheeseChoice = console.promptForString("""
                            Pick your cheese fixings:
                            [1] American
                            [2] Provolone
                            [3] Cheddar
                            [4] Swiss
                            """);

                    switch (cheeseChoice) {
                        case "1": cheeseChoice = "American"; break;
                        case "2": cheeseChoice = "Provolone"; break;
                        case "3": cheeseChoice = "Cheddar"; break;
                        case "4": cheeseChoice = "Swiss"; break;
                        default: System.out.println("Invalid cheese choice. Please choose from the menu options."); break;
                    }
                    
                    // prompt user to decide if they want extra toppings
                    String extraCheese = console.promptForString("Would you like an extra fixing? Y/N ");
                    boolean addExtraCheese = extraCheese.equals("Y");

                    return new Topping(cheeseChoice, addExtraCheese, true, false);
                } while (cheeseChoice != null);
            }

        }
            return null;
    }

    private Topping customizeRegularTopping(String toppingType) {
        String regularChoice = console.promptForString("""
                What can we fix on your sandwich?
                [1] Regular Toppings
                [2] Sauces
                """);

        if (regularChoice.equals("1")) {
            String toppingChoice = console.promptForString("""
                    Pick your fixings:
                    [1] Lettuce
                    [2] Peppers
                    [3] Onion
                    [4] Tomatoes
                    [5] Jalapenos
                    [6] Cucumbers
                    [7] Pickles
                    [8] Guacamole
                    [9] Mushrooms
                    """);

            switch (toppingChoice) {
                case "1": toppingChoice = "Lettuce"; break;
                case "2": toppingChoice = "Peppers"; break;
                case "3": toppingChoice = "Onion"; break;
                case "4": toppingChoice = "Tomatoes"; break;
                case "5": toppingChoice = "Jalapenos"; break;
                case "6": toppingChoice = "Cucumbers"; break;
                case "7": toppingChoice = "Pickles"; break;
                case "8": toppingChoice = "Guacamole"; break;
                case "9": toppingChoice = "Mushrooms"; break;
                default: System.out.println("Invalid topping choice. Please choose from the menu options.");
            }

            boolean addExtraTopping = false;
            String extraTopping = console.promptForString("Would you like an extra fixing? Y/N ");
            
            if(extraTopping.equals("Y")){
                addExtraTopping = true;
            }
            
            return new Topping(toppingChoice, addExtraTopping, false, false);
        
        } else if (regularChoice.equals("2")) {
            String sauceChoice = console.promptForString("""
                    Pick your sauce fixings:
                    [1] Mayo
                    [2] Mustard
                    [3] Ketchup
                    [4] Ranch
                    [5] Thousand Island
                    [6] Vinaigrette
                    """);

            switch (sauceChoice) {
                case "1":
                    sauceChoice = "Mayo";
                case "2":
                    sauceChoice = "Mustard";
                case "3":
                    sauceChoice = "Ketchup";
                case "4":
                    sauceChoice = "Ranch";
                case "5":
                    sauceChoice = "Thousand Island ";
                case "6":
                    sauceChoice = "Vinaigrette";
                default:
                    System.out.println("Invalid sauce choice. Please choose from the menu options.");
            }
            
            boolean addExtraSauce = false;

            String extraSauce = console.promptForString("Would you like an extra fixing? Y/N ");

            if(extraSauce.equals("Y")){
                addExtraSauce = true;
            }

            return new Topping(sauceChoice, addExtraSauce, false, false);
        }
        return null;
    }
    
    private Drink customizeDrinkOrder(){
        String drinkFlavors = console.promptForString("""
            What flavor soda fits your fixings? :
            [1] Coke Cherry
            [2] Dr. Pepper
            [3] Fanta Orange
            [4] Ginger Ale (Canada Dry)
            """);

        switch(drinkFlavors){
            case "1": drinkFlavors = "Coke Cherry"; break;
            case "2": drinkFlavors = "Dr. Pepper"; break;
            case "3": drinkFlavors = "Fanta Orange"; break;
            case "4": drinkFlavors = "Ginger Ale (Canada Dry)"; break;
            default: System.out.println("Invalid Input. Please Try Again."); break;
        }

        return new Drink(drinkFlavors);
    }
    
    private Chips customizeChipsOrder(){
        String chipsFlavor = console.promptForString("""
                        What flavor chips fit your fixings? :
                        [1] Baked Jalapeno
                        [2] Flamin' Hot Cheetos Puffs
                        [3] Funyons
                        [4] Baked Cheddar Cheese
                        """);

        switch(chipsFlavor){
            case "1": chipsFlavor = "Baked Jalapeno"; break;
            case "2": chipsFlavor = "Flamin' Hot Cheetos Puffs"; break;
            case "3": chipsFlavor = "Funyons"; break;
            case "4": chipsFlavor = "Baked Cheddar Cheese"; break;
            default: System.out.println("Invalid Input. Please Try Again."); break;
        }

        return new Chips(chipsFlavor);
    }
    
    public void showCompleteOrder(List <OrderItem> list){
        // can refactor the code to increase readability
        System.out.println(Order.timeOfOrder
        + "This is your complete order: ");
        for(OrderItem item : list){
            System.out.printf("%s: %f.2f", item.orderItemDescription(), item.orderItemPrice());
            
        }
    }
}

// add logic to allow for multiple toppings?
// would need to save every addition into a StringBuilder variable
// prompt user to decide a sauce