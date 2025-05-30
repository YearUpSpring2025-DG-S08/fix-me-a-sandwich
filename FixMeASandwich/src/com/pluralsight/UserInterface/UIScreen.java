package com.pluralsight.UserInterface;

import com.pluralsight.FileManager.OrderManager;
import com.pluralsight.Menu.*;

public class UIScreen {
    private static final Console console = new Console();
    public static Sandwich sandwich;
    public static Order newOrder = new Order();
    public CreateOrderMenu createOrder = new CreateOrderMenu();
    public OrderManager orderManager = new OrderManager();

//    private void init(){
//        this.order = 
//    }

    // UIScreen display methods
    public void takeCustomerOrder() {

        System.out.println("""
                Welcome to Fix-Me-A-Sandwich!
                Where you can fully customize your sandwich to however you choose!""");

        String input = console.promptForString("Can I fix you a sandwich?: Y/N ");
        boolean wantSandwich = false;
        while (!wantSandwich) {
            if (input.equalsIgnoreCase("Y")) {

                int sandwichSize = console.promptForInt("""
                        Please choose a sandwich size:
                        [1] 4" - "Fix me a 4 inch"
                        [2] 8" - "Fix me a 8 inch"
                        [3] 12" - "Fix me a 12 inch
                        """);

                String getToasted;
                String breadType;
                boolean isToasted = false;
                switch (sandwichSize) {
                    case 1:
                        // prompt customers to choose toppings (create Topping object)
                        // to choose to toast their sandwich (boolean value true)
                        // add sides (create Chips/Drink object)
                        // confirm whether they want the order
                        sandwichSize = 4;
                        breadType = createOrder.customizeBread();
                        sandwich = new Sandwich(breadType, sandwichSize, isToasted);
                        createOrder.chooseToppings();

                        getToasted = console.promptForString("Would you like your sandwich toasted? Y/N ");
                        sandwich.setToasted(getToasted.equalsIgnoreCase("Y"));
                        newOrder.addItem(sandwich);
                        wantSandwich = true;
                        break;
                    case 2:
                        sandwichSize = 8;
                        breadType = createOrder.customizeBread();
                        sandwich = new Sandwich(breadType, sandwichSize, isToasted);
                        createOrder.chooseToppings();

                        getToasted = console.promptForString("Would you like your sandwich toasted? Y/N ");
                        sandwich.setToasted(getToasted.equalsIgnoreCase("Y"));
                        newOrder.addItem(sandwich);
                        wantSandwich = true;
                        break;
                    case 3:
                        sandwichSize = 12;
                        breadType = createOrder.customizeBread();
                        sandwich = new Sandwich(breadType, sandwichSize, isToasted);
                        createOrder.chooseToppings();

                        getToasted = console.promptForString("Would you like your sandwich toasted? Y/N ");
                        sandwich.setToasted(getToasted.equalsIgnoreCase("Y"));
                        newOrder.addItem(sandwich);
                        wantSandwich = true;
                        break;
                    default:
                        System.out.println("Invalid Input. Please Try Again");
                        break;
                }

            } else if (input.equalsIgnoreCase("N")) {
                System.out.println("Thank you for coming to Fix-Me-A-Sandwich! Have a wonderful day!");
            } else {
                System.out.println("Invalid Input. Please Try Again\n");
                takeCustomerOrder();
                break;
            }
        }

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
                case "1":
                    // go to method where a drink object is being created
                    createOrder.customizeDrinkOrder();
                    break;
                case "2":
                    // go to method where a chips object is being created
                    createOrder.customizeChipsOrder();
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
                        cancelOrder = true;
                    } else {
                        System.out.println("Returning to menu...");
                    }
                    break;
                default:
                    System.out.println("Invalid Input. Please Try Again");
                    break;
            }
        }
    }

    private void showCheckoutScreen() {
        // this is where we will need to utilize the Order class
        // to present the Customer and the list of OrderItems
        boolean orderConfirmed = false;
        String confirmOrder;
        while (!orderConfirmed) {
            System.out.println("""
                    === Checkout Screen ===
                    """);
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

                // confirm to user that order has been made
                // return customer to start screen
//                newOrder = new Order();
                takeCustomerOrder();
            } else {
                System.out.println("Order has been cancelled!");
                System.out.println("Thank you for coming to Fix-Me-A-Sandwich! Have a wonderful day!");
                newOrder = new Order();
            }
        }
    }
}