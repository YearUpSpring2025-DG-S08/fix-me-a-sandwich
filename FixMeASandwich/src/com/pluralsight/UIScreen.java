package com.pluralsight;

public class UIScreen {
    private static Console console = new Console();

    public void showHomeScreen() {

        System.out.println("Welcome to Fix-Me-A-Sandwich! " +
                "Where you can fully customize your sandwich to however you choose!");

        String input = console.promptForString("Can I fix you a sandwich?: Y/N");

        if (input.equalsIgnoreCase("Y")) {

            int sandwichSize = console.promptForInt("""
                    Please choose a sandwich size:
                    [1] 4" - "Fix me a 4 inch"
                    [2] 8" - "Fix me a 8 inch"
                    [3] 12" - "Fix me a 12 inch""");

            switch (sandwichSize) {
                case 1:
                    // prompt customers to choose toppings - go to method where a toppings object is being created
                    // to choose to toast their sandwich
                    // add sides
                    // confirm whether they want the order
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
        } else {
            System.out.println("Thank you for coming to Fix-Me-A-Sandwich! Have a wonderful day!");
        }

        // extrapolate this further logic into a separate method?
        String addOnSides = console.promptForString("Would you like to add on some sides?" +
                "[1] Add a Drink" +
                "[2] Add some Chips" +
                "[0] Go to Checkout" +
                "[X] Cancel Order");

        switch (addOnSides) {
            case "1":
                // go to method where a drink object is being created
                break;
            case "2":
                // go to method where a chips object is being created
                break;
            case "0":
                // go to checkout screen
                break;
            case "X":
                // confirm order cancellation
                // make sure the order does not get saved into the file
                break;
            default:
                System.out.println("Invalid Input. Please Try Again");
                break;
        }
    }

    // helper method
    private void customizeBread() {
        // prompt user to decide a bread choice
        String breadType = console.promptForString("""
                What type of bread do you want?:
                [1] Fix me some white
                [2] Fix me some wheat
                [3] Fix me some rye
                [4] Fix me a wrap
                """);

        switch (breadType) {
            case "1":
                breadType = "white";
                break;
            case "2":
                breadType = "wheat";
                break;
            case "3":
                breadType = "rye";
                break;
            case "4":
                breadType = "wrap";
                break;
            default:
                System.out.println("Invalid Input. Please Try Again.");
                break;
        }


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
                String meatChoice = console.promptForString("""
                        Pick your meat fixings:
                        [1] Steak
                        [2] Ham
                        [3] Salami
                        [4] Roast Beef
                        [5] Chicken
                        [6] Bacon
                        """);

                switch (meatChoice) {
                    case "1":
                        meatChoice = "Steak";
                    case "2":
                        meatChoice = "Ham";
                    case "3":
                        meatChoice = "Salami";
                    case "4":
                        meatChoice = "Roast Beef";
                    case "5":
                        meatChoice = "Chicken";
                    case "6":
                        meatChoice = "Bacon";
                    default:
                        System.out.println("Invalid meat choice. Please choose from the menu options.");
                }
                // prompt user to decide if they want extra toppings
                boolean addExtraMeat = false;
                String extraMeat = console.promptForString("Would you like an extra fixing? Y/N ");

                if (extraMeat.equals("Y")) {
                    addExtraMeat = true;
                }

                return new Topping(meatChoice, addExtraMeat, true, true);

            } else if (premiumChoice.equals("2")) {
                String cheeseChoice = console.promptForString("""
                        Pick your cheese fixings:
                        [1] American
                        [2] Provolone
                        [3] Cheddar
                        [4] Swiss
                        """);

                switch (cheeseChoice) {
                    case "1":
                        cheeseChoice = "American";
                    case "2":
                        cheeseChoice = "Provolone";
                    case "3":
                        cheeseChoice = "Cheddar";
                    case "4":
                        cheeseChoice = "Swiss";
                    default:
                        System.out.println("Invalid cheese choice. Please choose from the menu options.");
                }
            }
            // prompt user to decide if they want extra toppings
            String extraCheese = console.promptForString("Would you like an extra fixing? Y/N ");
            boolean addExtraCheese = false;

            if (extraCheese.equals("Y")) {
                addExtraCheese = true;
            }
            return new Topping(extraCheese, addExtraCheese, true, false);
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
                case "1":
                    toppingChoice = "Lettuce";
                case "2":
                    toppingChoice = "Peppers";
                case "3":
                    toppingChoice = "Onion";
                case "4":
                    toppingChoice = "Tomatoes";
                case "5":
                    toppingChoice = "Jalapenos";
                case "6":
                    toppingChoice = "Cucumbers";
                case "7":
                    toppingChoice = "Pickles";
                case "8":
                    toppingChoice = "Guacamole";
                case "9":
                    toppingChoice = "Mushrooms";
                default:
                    System.out.println("Invalid topping choice. Please choose from the menu options.");
            }

            boolean addExtraTopping = false;
            String extraTopping = console.promptForString("Would you like an extra fixing? Y/N ");
            
            if(extraTopping.equals("Y")){
                addExtraTopping = true;
            }
            
            return new Topping(toppingChoice, addExtraTopping, false, false);
            // add logic to allow for multiple toppings?
            // would need to save every addition into a StringBuilder variable
            // prompt user to decide a sauce
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
}
