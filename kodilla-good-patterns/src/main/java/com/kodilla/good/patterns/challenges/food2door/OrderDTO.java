package com.kodilla.good.patterns.challenges.food2door;

public class OrderDTO {

    private String productName;
    private String producerName;
    private double totalPrice;
    private boolean ordered;

    public OrderDTO(Order order, String producerName, boolean ordered) {
        this.productName = order.getOrderedProduct().getName();
        this.producerName = producerName;
        this.ordered = ordered;
        totalPrice = order.getOrderedProduct().getPrice() * order.getQuantity();
    }

    public String getProductName() {
        return productName;
    }

    public String getProducerName() {
        return producerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public boolean isOrdered() {
        return ordered;
    }
}
