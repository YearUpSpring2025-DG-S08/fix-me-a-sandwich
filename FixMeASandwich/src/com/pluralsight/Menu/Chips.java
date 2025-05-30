package com.pluralsight.Menu;

public class Chips implements OrderItem {
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

    public void setChipsFlavor(String chipsFlavor) {
        this.chipsFlavor = chipsFlavor;
    }

    @Override
    public String orderItemDescription() {
        return String.format("""
                \n=== Chip ===\n
                %s: $%.2f\n", chipsFlavor, orderItemPrice()""");
    }

    @Override
    public double orderItemPrice() {
        return chipsPrice;
    }
}
