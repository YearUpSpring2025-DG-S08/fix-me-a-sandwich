package com.pluralsight;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    // saves the details of an overall order
    // a Customer a Sandwich a Chip/Drink
    // uses the OrderItem interface to identify the key values needed from each object
    public static final LocalDateTime timeOfOrder = LocalDateTime.now();
    public static final List<OrderItem> orderItems = new ArrayList<>();
    
    
    public void test(){
        Order o = new Order();
        Sandwich s = new Sandwich("White", 1, true);
        s.addMeat("Ham", true);

        o.addItem(s);

    }
    
    public void addItem(OrderItem item){
        orderItems.add(item);
        
        if(orderItems == null){
            System.out.println("The list is null");
        }
    }
}
