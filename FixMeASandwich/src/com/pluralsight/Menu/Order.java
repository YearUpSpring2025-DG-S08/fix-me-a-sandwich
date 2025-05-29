package com.pluralsight.Menu;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    // saves the details of an overall order
    // a Customer a Sandwich a Chip/Drink
    // uses the OrderItem interface to identify the key values needed from each object
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    public static final LocalDateTime timeOfOrder = LocalDateTime.now();
    public static final List<OrderItem> orderItems = new ArrayList<>();


    public void addItem(OrderItem item) {
        orderItems.add(item);
    }
    

    public void showCompleteOrder(List<OrderItem> list) {
        // can refactor the code to increase readability
        System.out.print("Order Created: " + Order.timeOfOrder.format(formatter) + "\n");

        if (list.isEmpty()) {
            System.out.println("This list is empty");
        } else {
            for (OrderItem item : list) {
                System.out.printf("%s: $%.2f\n", item.orderItemDescription(), item.orderItemPrice());
            }
        }
    }
}
