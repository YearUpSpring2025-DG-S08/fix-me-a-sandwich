package com.pluralsight.FileManager;


import com.pluralsight.Menu.Original.Order;
import com.pluralsight.Menu.Interfaces.OrderItem;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class OrderManager {
// this class will manage Orders from customers
// and will write the confirmed Orders to the file
    private static final String dir = "ReceiptsFolder/";
    
    public void saveReceipt(Order customerOrder){
        File filePath = new File(dir, createFileName());
        
        try(PrintWriter orderWriter = new PrintWriter(new FileWriter(filePath))){

            // write order time
            LocalDateTime orderTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
            
            // write customer name
            String customerName = customerOrder.getCustomer() != null ? customerOrder.getCustomer() : "no name";
            
            orderWriter.printf("""
                    ==== Order Receipt ===
                    Time of Order: %s
                    Customer Name: %s
                    Order Items:
                    """, orderTime.toString().replace("T", "//|"), customerName);
            
            // write each OrderItem description and price
            for(OrderItem item: customerOrder.orderItems) {
                orderWriter.write(item.orderItemDescription());
                orderWriter.write("\n");
            }
            
            
        } catch (IOException e){
            System.out.println("Could not write to file");
        }
    }
    
    public static String createFileName(){
        LocalDateTime currentDate = LocalDateTime.now();
        StringBuilder fileName = new StringBuilder();

        System.out.println(currentDate.toLocalDate());

        for (String dateString: currentDate.toLocalDate().toString().split("-")){
            fileName.append(dateString);
        }

        fileName.append("-");

        for (String timeString: currentDate.toLocalTime().truncatedTo(ChronoUnit.SECONDS).toString().split(":")){
            fileName.append(timeString);
        }
        fileName.append(".txt");
        
        return fileName.toString();
    }
}
