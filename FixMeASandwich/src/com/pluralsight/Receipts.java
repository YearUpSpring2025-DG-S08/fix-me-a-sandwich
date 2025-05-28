package com.pluralsight;

/*
each customer will have their Sandwiches saved within them
but the CustomerOrder will have access to their Sandwich prices.
 */

import java.util.ArrayList;
import java.util.List;

public class Receipts {
    // the current idea is to map these together
    // making matches for each Sandwich, Side, and Customer where they're all created at the same time
    // then mapped into a whole new CustomerOrders array list
    public List<Sandwich> sandwiches = new ArrayList<>();
    public List<Customer> customers = new ArrayList<>();
// will hold Customer, Sandwich, and Sides within an arraylist (?)
    // this data will be saved to the receiptFileManager to be printed to a customer
}
