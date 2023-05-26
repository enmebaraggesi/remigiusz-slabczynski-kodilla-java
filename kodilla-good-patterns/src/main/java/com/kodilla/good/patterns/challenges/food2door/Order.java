package com.kodilla.good.patterns.challenges.food2door;

public class Order {

    private int orderNumber;
    private double quantity;
    private ProductType orderedProduct;

    public Order(int orderNumber, double quantity, ProductType orderedProduct) {
        this.orderNumber = orderNumber;
        this.quantity = quantity;
        this.orderedProduct = orderedProduct;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public double getQuantity() {
        return quantity;
    }

    public ProductType getOrderedProduct() {
        return orderedProduct;
    }
}
