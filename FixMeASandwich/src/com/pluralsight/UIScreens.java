package com.pluralsight;

public class UIScreens {
    private static Console console = new Console();
    
    public void showHomeScreen(){

        System.out.println("Welcome to Fix-Me-A-Sandwich! " +
                "Where you can fully customize your sandwich to however you choose!");
        
        String input = console.promptForString("Can I fix you a sandwich?: Y/N");

        if (input.equalsIgnoreCase("Y")) {
            
            int sandwichSize = console.promptForInt("""
                    Please choose a sandwich size: 
                    [1] 4" - "Fix me a 4 inch"
                    [2] 8" - "Fix me a 8 inch"
                    [3] 12" - "Fix me a 12 inch"
                    """);
            
            switch(sandwichSize){
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
        } else{
            
        }
        
        // extrapolate this further logic into a separate method?
            String addOnSides = console.promptForString("Would you like to add on some sides?" +
                    "[1] Add a Drink" +
                    "[2] Add some Chips" +
                    "[0] Go to Checkout" +
                    "[X] Cancel Order");
        
        switch(addOnSides){
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
    private void customizeOrder(){
        // prompt user to decide a bread choice
        String breadType = console.promptForString("""
                What type of bread do you want?:
                [1] Fix me some white
                [2] Fix me some wheat
                [3] Fix me some rye
                [4] Fix me a wrap
                """);
        
        switch(breadType){
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
        // prompt user to decide a sauce
        String sauceType = console.promptForString("""
                What type of sauce do you want?:
                [1] Fix it with some Marinara
                [2] Fix it with some Tomato Basil
                [3] Fix it with some White Sauce
                [4] Fix it with some Custom Sauce
                """);
        
        switch(sauceType){
            case "1":
                sauceType = "Marinara";
                break;
            case "2":
                sauceType = "Tomato Basil";
                break;
            case "3":
                sauceType = "White Sauce";
                break;
            case "4":
                sauceType = console.promptForString("Name your sauce: ");
                break;
            default:
                System.out.println("Invalid Input. Please Try Again.");
                break;
        }
        // prompt user to decide toppings
        String toppingType = """
                Please choose your toppings:
                [1] Premium (meat/cheese)
                [2] Regular (other)
                """;
        
        
        // prompt user to decide if they want extra toppings
        // prompt user to decide if they want to toast their sandwich
        // create a new Sandwich
    }
}
