package com.pluralsight;

public class UIScreen {
    private static final Console console = new Console();
    private final Order order = new Order();
    private boolean isToasted;
    private Sandwich sandwich;
//    private void init(){
//        this.order = 
//    }
    
    // UIScreen display methods
    public void takeCustomerOrder() {

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
            
            String getToasted;
            String breadType = customizeBread();
            switch (sandwichSize) {
                case 1:
                    // prompt customers to choose toppings (create Topping object)
                    // to choose to toast their sandwich (boolean value true)
                    // add sides (create Chips/Drink object)
                    // confirm whether they want the order
                    sandwichSize = 4;
                    sandwich = new Sandwich(breadType, sandwichSize, isToasted);
                    chooseToppings();
                    
                    getToasted = console.promptForString("Would you like your sandwich toasted? Y/N ");
                    isToasted = getToasted.equalsIgnoreCase("Y");
                    order.addItem(sandwich);
                    break;
                case 2:
                    sandwichSize = 8;
                    sandwich = new Sandwich(breadType, sandwichSize, isToasted);
                    chooseToppings();
                    
                    getToasted = console.promptForString("Would you like your sandwich toasted? Y/N ");
                    isToasted = getToasted.equalsIgnoreCase("Y");
                    order.addItem(sandwich);
                    break;
                case 3:
                    sandwichSize = 12;
                    sandwich = new Sandwich(breadType, sandwichSize, isToasted);
                    chooseToppings();
                    
                    getToasted = console.promptForString("Would you like your sandwich toasted? Y/N ");
                    isToasted = getToasted.equalsIgnoreCase("Y");
                    order.addItem(sandwich);
                    break;
                default:
                    System.out.println("Invalid Input. Please Try Again");
                    break;
            }
            
        } else {
            System.out.println("Thank you for coming to Fix-Me-A-Sandwich! Have a wonderful day!");
        }
        
        String addOnSides;
        do {
            addOnSides = console.promptForString("""
                    Would you like to add on some sides?
                    [1] Add a Drink
                    [2] Add some Chips
                    [C] Go to Checkout
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
                case "C":
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
                    addOnSides = "";
                    break;
            }
        } while (!addOnSides.equalsIgnoreCase("X"));
    }
    
    private void showCheckoutScreen(){
        // this is where we will need to utilize the Order class
        // to present the Customer and the list of OrderItems
        System.out.println("This is the checkout screen: ");
        order.showCompleteOrder(Order.orderItems);
    }
    
    // helper methods
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
            customizePremiumToppings();
        } else if (toppingType.equals("2")) {
            customizeRegularTopping();
        }
        // prompt user to decide if they want to toast their sandwich
        // create a new Sandwich
    }

    private void customizePremiumToppings() {
            String premiumChoice = UIScreen.console.promptForString("""
                    What can we fix on your sandwich?
                    [1] Meat
                    [2] Cheese
                    """);
            
            if (premiumChoice.equals("1")) {
                boolean meatChosen = false;
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

                    if(!meatChoice.isBlank()) {
                        meatChosen = true;
                    } else{
                        System.out.println("You must select a meat to make a sandwich");
                    }

                } while (!meatChosen);
                
                    // prompt user to decide if they want extra toppings
                    boolean addExtraMeat;
                    String extraMeat = console.promptForString("Would you like an extra fixing? Y/N ");
                    addExtraMeat = extraMeat.equals("Y");
                    
                    Topping meatTopping = new Topping(meatChoice, addExtraMeat, true, true);
                    sandwich.toppings.add(meatTopping);
                    
                
            } else if (premiumChoice.equals("2")) {
                boolean cheeseChosen = false;
                String cheeseChoice;
                do {
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
                    
                    if(!cheeseChoice.isBlank()){
                        cheeseChosen = true;
                    } else{
                        System.out.println("You must select a cheese to make a sandwich");
                    }
                    
                } while (!cheeseChosen);
                
                    // prompt user to decide if they want extra toppings
                    String extraCheese = console.promptForString("Would you like an extra fixing? Y/N ");
                    boolean addExtraCheese = extraCheese.equals("Y");

                    Topping cheeseTopping = new Topping(cheeseChoice, addExtraCheese, true, false);
                    sandwich.toppings.add(cheeseTopping);
            }
    }

    private void customizeRegularTopping() {
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
            
            Topping regularTopping = new Topping(toppingChoice, addExtraTopping, false, false);
            sandwich.toppings.add(regularTopping);
        
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

            sauceChoice = switch (sauceChoice) {
                case "1" -> "Mayo";
                case "2" -> "Mustard";
                case "3" -> "Ketchup";
                case "4" -> "Ranch";
                case "5" -> "Thousand Island ";
                case "6" -> "Vinaigrette";
                default -> "";
                };
            

            String extraSauce = console.promptForString("Would you like an extra fixing? Y/N ");
            boolean addExtraSauce = extraSauce.equals("Y");

            Topping sauce = new Topping(sauceChoice, addExtraSauce, false, false);
            sandwich.toppings.add(sauce);
        }
    }
    
    private void customizeChipsOrder(){
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

        Chips chips = new Chips(chipsFlavor);
        order.addItem(chips);
    }
    
    private void customizeDrinkOrder(){
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

        Drink drink = new Drink(drinkFlavors);
        order.addItem(drink);
    }
    
}

// add logic to allow for multiple toppings?
// would need to save every addition into a StringBuilder variable
// prompt user to decide a sauce