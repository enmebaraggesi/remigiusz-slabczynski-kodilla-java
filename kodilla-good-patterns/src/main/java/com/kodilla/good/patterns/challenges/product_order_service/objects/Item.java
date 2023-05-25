package com.kodilla.good.patterns.challenges.product_order_service.objects;

public class Item {

    private String itemName;
    private int itemSerialNumber;

    public Item(String itemName, int itemSerialNumber) {
        this.itemName = itemName;
        this.itemSerialNumber = itemSerialNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemSerialNumber() {
        return itemSerialNumber;
    }
}
