package com.pluralsight;

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
    
    
    public void addItem(OrderItem item){
        orderItems.add(item);
    }
    
//    public void showOrder(){
//        List<String> completeOrderItems = orderItems.stream()
//                .map(OrderItem::orderItemDescription)
//                .toList();
//        
//        List<Double> completeOrderPrices = orderItems.stream()
//                .map(OrderItem::orderItemPrice)
//                .toList();
//    }

    public void showCompleteOrder(List <OrderItem> list){
        // can refactor the code to increase readability
        System.out.println(Order.timeOfOrder.format(formatter)
                + "\n This is your complete order: ");
        
        if(list.isEmpty()){
            System.out.println("This list is empty");
        } else{
            System.out.println("There's stuff in this list");
        }
//        for(OrderItem item : list){
//            System.out.printf("%s: %f.2f", item.orderItemDescription(), item.orderItemPrice());
//
//        }
    }
}
