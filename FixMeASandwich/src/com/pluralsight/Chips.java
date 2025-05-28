package com.pluralsight;

public class Chips implements OrderItem{
    private String chipsFlavor;
    private final double chipsPrice = 1.50;

    public Chips(String chipsFlavor) {
        this.chipsFlavor = chipsFlavor;
    }
    
    public String getChipsFlavor() {
        return chipsFlavor;
    }

    public double getChipsPrice() {
        return chipsPrice;
    }

    @Override
    public String orderItemDescription() {
        return String.format("%s", chipsFlavor);
    }

    @Override
    public double orderItemPrice() {
        return chipsPrice;
    }
}
