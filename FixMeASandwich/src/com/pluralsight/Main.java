package com.pluralsight;

import com.pluralsight.Menu.Original.Sandwich;
import com.pluralsight.Menu.Original.Topping;
import com.pluralsight.Menu.SignatureSandwiches.BLT;
import com.pluralsight.UserInterface.OrderScreen;

public class Main {
    public static void main(String[] args) {

        OrderScreen OrderScreen = new OrderScreen();
        OrderScreen.takeSandwichOrder();

    }
}