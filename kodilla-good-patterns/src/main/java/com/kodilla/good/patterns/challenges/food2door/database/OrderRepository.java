package com.kodilla.good.patterns.challenges.food2door.database;

import com.kodilla.good.patterns.challenges.food2door.Order;

public class OrderRepository implements OrderReception {

    @Override
    public void registerOrder(Order order) {
        System.out.println("Order " + order.getOrderNumber() + " saved in database.");
    }
}
