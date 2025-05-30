package com.pluralsight.Menu.Interfaces;

// created to group each menu item together
// allowing for items to be added to a list and outputting to the user for order confirmation
// as well as writing a receipt to a file
public interface OrderItem {
    
    String orderItemDescription();
    double orderItemPrice();
}
