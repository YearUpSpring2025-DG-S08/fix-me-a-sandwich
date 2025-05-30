package com.pluralsight.Menu.Original;

import com.pluralsight.Menu.Interfaces.OrderItem;

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
                \n
                === Chip ===
                %s: $%.2f"""
                , chipsFlavor, orderItemPrice());
    }

    @Override
    public double orderItemPrice() {
        return chipsPrice;
    }
}
