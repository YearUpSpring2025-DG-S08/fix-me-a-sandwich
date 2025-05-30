package com.pluralsight.UserInterface;

import com.pluralsight.FileManager.OrderManager;
import com.pluralsight.Menu.Original.Order;
import com.pluralsight.Menu.Original.Sandwich;

public class OrderScreen {
    private static final Console console = new Console();
    public static Sandwich sandwich = new Sandwich();
    public static Order newOrder = new Order();
    public static FixMeABasicSandwich basicSandwichBuilder = new FixMeABasicSandwich();
    public static FixMeASignatureSandwich signatureSandwich = new FixMeASignatureSandwich();
    public static OrderManager orderManager = new OrderManager();

//    private void init(){
//        this.order = 
//    }

    // UIScreen display methods
    public static void takeSandwichOrder() {

        System.out.println("""
                Welcome to Fix-Me-A-Sandwich!
                Where you can fully customize your sandwich to however you choose!""");

        boolean wantSandwich = false;
        while (!wantSandwich) {
        String input = console.promptForString("Can I fix you a sandwich?: Y/N ");
            if (input.equalsIgnoreCase("Y")) {

                int sandwichSize = console.promptForInt("""
                        Please choose a sandwich size:
                        [1] 4" - "Fix me a 4 inch"
                        [2] 8" - "Fix me a 8 inch"
                        [3] 12" - "Fix me a 12 inch
                        [4] "Fix me a Signature Sandwich"
                        """);

                
                // chose to separate these variables to make it easier to create a Sandwich without waiting until
                // the end of an order - necessary to add toppings to sandwich
                String getToasted;
                String breadType;
                boolean isToasted = false;
                switch (sandwichSize) {
                    case 1 -> {
                      createBasicSandwich(4);
                        wantSandwich = true;
                    }
                    case 2 -> {
                        createBasicSandwich(8);
                        wantSandwich = true;
                    }
                    case 3 -> {
                        createBasicSandwich(12);
                        wantSandwich = true;
                    }
                    case 4 -> {
                        newOrder.addItem(signatureSandwich.customizeSignatureSandwich());
                        wantSandwich = true;
                    }
                    default -> System.out.println("Invalid Input. Please Try Again");
                }

            } else if (input.equalsIgnoreCase("N")) {
                System.out.println("Thank you for coming to Fix-Me-A-Sandwich! Have a wonderful day!");
                wantSandwich = true;
            } else {
                System.out.println("Invalid Input. Please Try Again \n");
            }
        }
        
        takeSideOrder();
    }

    private static void createBasicSandwich(int size) {
        String breadType = basicSandwichBuilder.customizeBread();
        Sandwich sandwich = new Sandwich(breadType, size, false);
        FixMeABasicSandwich.chooseToppings();
        String getToasted = console.promptForString("Would you like your sandwich toasted? Y/N ");
        sandwich.setToasted(getToasted.equalsIgnoreCase("Y"));
        newOrder.addItem(sandwich);
    }


    // separated sandwich order and sides order to reduce a wall of code - increase readability
    // allow for better error handling and separation of responsibilities between methods
    public static void takeSideOrder(){
        String addOnSides;
        boolean cancelOrder = false;
        while (!cancelOrder) {
            addOnSides = console.promptForString("""
                    Would you like to add on some sides?
                    [1] Add a Drink
                    [2] Add some Chips
                    [C] Go to Checkout
                    [X] Cancel Order
                    """);

            switch (addOnSides) {
                    // go to method where a drink object is being created
                case "1" -> basicSandwichBuilder.addDrinkToOrder();
                    // go to method where a chips object is being created
                case "2" -> basicSandwichBuilder.addChipsToOrder();
                    // go to checkout screen
                case "C" -> showCheckoutScreen();
                // allowing two points of cancellation - before and after user receives price of items
                case "X" -> {
                    String confirmCancellation = console.promptForString("Are you sure you want to cancel the order? Y/N ");
                    if (confirmCancellation.equalsIgnoreCase("Y")) {
                        System.out.println("Order has been cancelled!");
                        System.out.println("Thank you for coming to Fix-Me-A-Sandwich! Have a wonderful day!");
                        cancelOrder = true;
                    } else {
                        System.out.println("Returning to menu...");
                    }
                }
                default -> System.out.println("Invalid Input. Please Try Again");
            }
        }
    }
    
    // separate checkout screen to confirm or cancel order
    public static void showCheckoutScreen() {
        // this is where we will need to utilize the Order class
        // to present the Customer and the list of OrderItems
        boolean orderConfirmed = false;
        String confirmOrder;
        while (!orderConfirmed) {
            System.out.println("""
                    === Checkout Screen ===""");
            newOrder.showCompleteOrder();

            confirmOrder = console.promptForString("""
                    Do you want to continue with your order? Y/N
                    """);

            if (confirmOrder.equalsIgnoreCase("Y")) {
                String userName = console.promptForString("Can I fix a name to the order? ");


                if (!userName.isBlank()) {
                    newOrder.setCustomer(userName);
                    // save order to file
                    orderManager.saveReceipt(newOrder);
                    System.out.println("Your order has successfully been entered\n");
                    orderConfirmed = true;
                }

            } else {
                System.out.println("Order has been cancelled!");
                System.out.println("Thank you for coming to Fix-Me-A-Sandwich! Have a wonderful day!");
                newOrder = new Order();
            }
            // confirm to user that order has been made
            // return customer to start screen
            takeSandwichOrder();
        }
    }
}