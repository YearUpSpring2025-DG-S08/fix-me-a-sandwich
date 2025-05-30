package com.pluralsight.Menu;


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
    
    
    public Order(){
      
    }

    public String getCustomer(){
        return customer;
    }
    
    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public LocalDateTime getTimeOfOrder(){
        return timeOfOrder;
    }

    public void addItem(OrderItem item) {
        orderItems.add(item);
    }
    
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

        System.out.printf("\nTotal Cost of Order is: $%.2f\n", getOrderCost(orderItems));
    }

    public double getOrderCost(List<OrderItem> list){
        double totalCost = 0;
        
        for(OrderItem cost : list){
            totalCost += cost.orderItemPrice();
        }
        // need this to display a final cost of order
        return totalCost;
    }
}
