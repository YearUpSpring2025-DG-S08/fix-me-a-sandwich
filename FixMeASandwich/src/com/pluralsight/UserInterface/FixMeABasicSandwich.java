package com.pluralsight.UserInterface;

import com.pluralsight.Menu.Original.Chips;
import com.pluralsight.Menu.Original.Drink;
import com.pluralsight.Menu.Original.Topping;

@SuppressWarnings("UnusedAssignment")
// created a new class to handle sandwich creation
// mainly due to separation of responsibility between OrderScreen and this screen
// partially due to wall of code build up - necessary to clean up code and make it easier to find and correct errors
public class FixMeABasicSandwich {
    private static final Console console = new Console();

    // basic sandwich creation menu
    public String customizeBread() {
        boolean breadChosen = false;
        String breadType = "";
        while (!breadChosen) {
            // prompt user to decide a bread choice
            breadType = console.promptForString("""
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

            if(!breadType.isBlank()){
                breadChosen = true;
            }
        }
        return breadType;
    }

    public static void chooseToppings() {
        // prompt user to decide toppings
        String premiumChoice = console.promptForString("""
                    What can I fix on your sandwich?
                    === Premium ===
                    [1] Meat
                    [2] Cheese
                    
                    === Regular ===
                    [3] Veggies
                    [4] Sauce
                    """);

        switch (premiumChoice) {
            case "1" -> addMeatTopping();
            case "2" -> addCheeseTopping();
            case "3" -> addVeggiesToSandwich();
            case "4" -> addSauceToSandwich();
        }
    }

    public static void addMeatTopping() {
        boolean meatChosen = false;
        String meatChoice = "";
        while (!meatChosen) {
            meatChoice = console.promptForString("""
                            Pick your meat fixings:
                            [1] Steak
                            [2] Ham
                            [3] Salami
                            [4] Roast Beef
                            [5] Chicken
                            [6] Bacon
                            """);

            meatChoice = switch (meatChoice) {
                case "1" -> "Steak";
                case "2" -> "Ham";
                case "3" -> "Salami";
                case "4" -> "Roast Beef";
                case "5" -> "Chicken";
                case "6" -> "Bacon";
                default -> {
                    System.out.println("Invalid meat choice. Please choose from the menu options.");
                    yield "";
                }
            };


            if (!meatChoice.isBlank()) {
                meatChosen = true;
            } else{
                System.out.println("You must select a meat to make a sandwich");
            }
        }

        // prompt user to decide if they want extra toppings
        boolean addExtraMeat = false;
        while(!addExtraMeat) {
            String extraMeat = console.promptForString("Would you like an extra fixing? Y/N ");
            switch (extraMeat.toUpperCase()){
                case "Y" -> {
                    Topping meatTopping = new Topping(meatChoice, true, true, true);
                    OrderScreen.sandwich.toppings.add(meatTopping);
                    addExtraMeat = true;
                }
                case "N" -> {
                    Topping meatTopping = new Topping(meatChoice, false, true, true);
                    OrderScreen.sandwich.toppings.add(meatTopping);
                    addExtraMeat = true;
                }
                default -> System.out.println("Invalid Input. Please Try Again");
            }
        }

        // Ask about more toppings after the meat topping has been added
        String moreTopping = console.promptForString("Would you like to add another topping? Y/N ");
        if(moreTopping.equalsIgnoreCase("Y")){
            chooseToppings();
        } else if(!moreTopping.equalsIgnoreCase("N")){
            System.out.println("Invalid Input. Going back to fixing a sandwich");
        }
    }

    public static void addCheeseTopping(){
        boolean cheeseChosen = false;
        String cheeseChoice = "";
        while (!cheeseChosen) {
            cheeseChoice = console.promptForString("""
                        Pick your cheese fixings:
                        [1] American
                        [2] Provolone
                        [3] Cheddar
                        [4] Swiss
                        """);

            cheeseChoice = switch (cheeseChoice) {
                case "1" -> "American";
                case "2" -> "Provolone";
                case "3" -> "Cheddar";
                case "4" -> "Swiss";
                default -> {
                    System.out.println("Invalid cheese choice. Please choose from the menu options.");
                    yield "";
                }
            };

            if (!cheeseChoice.isBlank()) {
                cheeseChosen = true;
            }
        }

        // prompt user to decide if they want extra toppings
        boolean addExtraCheese = false;
        while(!addExtraCheese) {
            String extraCheese = console.promptForString("Would you like an extra fixing? Y/N ");
            switch (extraCheese.toUpperCase()){
                case "Y" -> {
                    Topping cheeseTopping = new Topping(cheeseChoice, true, true, false);
                    OrderScreen.sandwich.toppings.add(cheeseTopping);
                    addExtraCheese = true;
                }
                case "N" -> {
                    Topping cheeseTopping = new Topping(cheeseChoice, false, true, false);
                    OrderScreen.sandwich.toppings.add(cheeseTopping);
                    addExtraCheese = true;
                }
                default -> System.out.println("Invalid Input. Please Try Again");
            }
        }

        // Ask about more toppings after the cheese topping has been added
        String moreTopping = console.promptForString("Would you like to add another topping? Y/N ");
        if(moreTopping.equalsIgnoreCase("Y")){
            chooseToppings();
        } else if(!moreTopping.equalsIgnoreCase("N")){
            System.out.println("Invalid Input. Going back to fixing a sandwich");
        }
    }

    public static void addVeggiesToSandwich() {
        boolean toppingChosen = false;
        String toppingChoice = "";

        while (!toppingChosen) {
            toppingChoice = console.promptForString("""
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

            toppingChoice = switch (toppingChoice) {
                case "1" -> "Lettuce";
                case "2" -> "Peppers";
                case "3" -> "Onion";
                case "4" -> "Tomatoes";
                case "5" -> "Jalapenos";
                case "6" -> "Cucumbers";
                case "7" -> "Pickles";
                case "8" -> "Guacamole";
                case "9" -> "Mushrooms";
                default -> {
                    System.out.println("Invalid topping choice. Please choose from the menu options.");
                    yield "";
                }
            };

            if (!toppingChoice.isBlank()) {
                toppingChosen = true;
            } else {
                System.out.println("You must select a topping");
            }
        }


        // once user inputs if they want extra, then we create the new Topping
        boolean addExtraTopping = false;
        while (!addExtraTopping) {
            String extraTopping = console.promptForString("Would you like an extra fixing? Y/N ");
            switch (extraTopping.toUpperCase()) {
                case "Y" -> {
                    Topping regularTopping = new Topping(toppingChoice, true, false, false);
                    OrderScreen.sandwich.toppings.add(regularTopping);
                    addExtraTopping = true;
                }
                case "N" -> {
                    Topping regularTopping = new Topping(toppingChoice, false, false, false);
                    OrderScreen.sandwich.toppings.add(regularTopping);
                    addExtraTopping = true;
                }
                default -> System.out.println("Invalid Input. Please Try Again");
            }
        }

        // Ask about more toppings after the veggie topping has been added
        String moreTopping = console.promptForString("Would you like to add another topping? Y/N ");
        if(moreTopping.equalsIgnoreCase("Y")){
            chooseToppings();
        } else if(!moreTopping.equalsIgnoreCase("N")){
            System.out.println("Invalid Input. Going back to fixing a sandwich");
        }
    }

    public static void addSauceToSandwich() {
        boolean sauceChosen = false;
        String sauceChoice = "";
        while (!sauceChosen) {
            sauceChoice = console.promptForString("""
                    Pick your sauce fixings:
                    [1] Mayo
                    [2] Mustard
                    [3] Ketchup
                    [4] Ranch
                    [5] Thousand Island
                    [6] Vinaigrette
                    [7] Au jus (side)
                    """);

            sauceChoice = switch (sauceChoice) {
                case "1" -> "Mayo";
                case "2" -> "Mustard";
                case "3" -> "Ketchup";
                case "4" -> "Ranch";
                case "5" -> "Thousand Island";
                case "6" -> "Vinaigrette";
                case "7" -> "Au jus (side)";
                default -> {
                    System.out.println("Invalid topping choice. Please choose from the menu options.");
                    yield "";
                }
            };

            if (!sauceChoice.isBlank()) {
                sauceChosen = true;
            } else{
                System.out.println("You must select a sauce");
            }
        } // end of while loop


        // once user inputs if they want extra, then we create the new Topping
        boolean addExtraSauce = false;

        while (!addExtraSauce) {
            String extraSauce = console.promptForString("Would you like an extra fixing? Y/N ");
            switch (extraSauce.toUpperCase()) {
                case "Y" -> {
                    Topping sauce = new Topping(sauceChoice, true, false, false);
                    OrderScreen.sandwich.toppings.add(sauce);
                    addExtraSauce = true;
                }
                case "N" -> {
                    Topping sauce = new Topping(sauceChoice, false, false, false);
                    OrderScreen.sandwich.toppings.add(sauce);
                    addExtraSauce = true;
                }
                default -> System.out.println("Invalid Input. Please Try Again");
            }
        }

        String moreSauce = console.promptForString("Would you like to add another sauce? Y/N ");
        switch (moreSauce.toUpperCase()){
            case "Y" -> addSauceToSandwich();
            case "N" -> { /* Continue to ask about more toppings */ }
            default -> System.out.println("Invalid Input. Please Try Again");
        }

        String moreTopping = console.promptForString("Would you like to add another topping? Y/N ");
        if(moreTopping.equalsIgnoreCase("Y")){
            chooseToppings();
        } else if(!moreTopping.equalsIgnoreCase("N")){
            System.out.println("Invalid Input. Going back to fixing a sandwich");
        }
    }

    public void addChipsToOrder() {
        boolean chipsChosen = false;
        while (!chipsChosen) {
            String chipsFlavor = console.promptForString("""
                    What flavor chips fit your fixings? :
                    [1] Baked Jalapeno
                    [2] Flamin' Hot Cheetos Puffs
                    [3] Funyons
                    [4] Baked Cheddar Cheese
                    """);

            chipsFlavor = switch (chipsFlavor) {
                case "1" -> "Baked Jalapeno";
                case "2" -> "Flamin' Hot Cheetos Puffs";
                case "3" -> "Funyons";
                case "4" -> "Baked Cheddar Cheese";
                default -> {
                    System.out.println("Invalid Input. Please Try Again.");
                    yield "";
                }
            };

            if(!chipsFlavor.isBlank()){
                Chips chips = new Chips(chipsFlavor);
                OrderScreen.newOrder.addItem(chips);
                chipsChosen = true;
            } else{
                System.out.println("You must select a chips flavor to make an order");
            }
        }
    }

    public void addDrinkToOrder() {
        boolean drinkChosen = false;
        do {
            String drinkFlavors = console.promptForString("""
                    What flavor soda fits your fixings? :
                    [1] Coke Cherry
                    [2] Dr. Pepper
                    [3] Fanta Orange
                    [4] Ginger Ale (Canada Dry)
                    """);

            drinkFlavors = switch (drinkFlavors) {
                case "1" -> "Coke Cherry";
                case "2" -> "Dr. Pepper";
                case "3" -> "Fanta Orange";
                case "4" -> "Ginger Ale (Canada Dry)";
                default -> {
                    System.out.println("Invalid Input. Please Try Again.");
                    yield "";
                }
            };

            String drinkSize = console.promptForString("""
                    What size soda fits your fixings?
                    [1] Small
                    [2] Medium
                    [3] Large
                    """);

            drinkSize = switch (drinkSize) {
                case "1" -> "Small";
                case "2" -> "Medium";
                case "3" -> "Large";
                default -> {
                    System.out.println("Invalid Input. Please Try Again.");
                    yield "";
                }
            };

            if(!(drinkFlavors.isBlank() && drinkSize.isBlank())){
                Drink drink = new Drink(drinkFlavors, drinkSize);
                OrderScreen.newOrder.addItem(drink);
                drinkChosen = true;
            } else{
                System.out.println("You must select a drink flavor and size to make an order");
            }
        } while (!drinkChosen);
    }
}
