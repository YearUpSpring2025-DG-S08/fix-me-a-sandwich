package com.pluralsight.Menu.Original;


import com.pluralsight.Menu.Interfaces.OrderItem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    // saves the details of an overall order
    // a Sandwich a Chip/Drink
    // uses the OrderItem interface to identify the key values needed from each object
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    public final LocalDateTime timeOfOrder = LocalDateTime.now();
    public final List<OrderItem> orderItems = new ArrayList<>();
    public String customer;
    
    // using a default constructor to allow for the creation of an Order without the details of a customer or their Order
    // necessary due to coded logic and steps to creating an order
    public Order(){
      
    }

    public String getCustomer(){
        return customer;
    }
    
    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void addItem(OrderItem item) {
        orderItems.add(item);
    }
    
    // used to display the entire user order for review and confirmation
    public void showCompleteOrder() {
        // can refactor the code to increase readability
        System.out.print("Order Created: " + timeOfOrder.format(formatter) + "\n");

        if (orderItems.isEmpty()) {
            System.out.println("This list is empty");
        } else {
            for (OrderItem item : orderItems) {
                System.out.printf("%s", item.orderItemDescription());
            }
        }

        System.out.printf("""
    \n=== Total Cost ===
    \n$%.2f\n""", getOrderCost(orderItems));
    }

    // combines items within the list to give final price
    // necessary due to combining items as OrderItem objects for easier encapsulation
    public double getOrderCost(List<OrderItem> list){
        double totalCost = 0;
        
        for(OrderItem cost : list){
            totalCost += cost.orderItemPrice();
        }
        // need this to display a final cost of order
        return totalCost;
    }
}
