package com.kodilla.good.patterns.challenges.food2door.producers;

import com.kodilla.good.patterns.challenges.food2door.*;
import com.kodilla.good.patterns.challenges.food2door.communication.OrderingService;
import com.kodilla.good.patterns.challenges.food2door.database.OrderReception;

public class ExtraFoodShop implements ProducerService {

    private final String name = "ExtraFoodShop";
    private final String emailAddress = "extra@food.com";

    private OrderingService orderingService;
    private OrderReception orderReception;
    private Order order;

    public ExtraFoodShop(OrderingService orderingService, OrderReception orderReception, Order order) {
        this.orderingService = orderingService;
        this.orderReception = orderReception;
        this.order = order;
    }

    @Override
    public OrderDTO process() {

        orderingService.sendOrder(order.getOrderNumber(), emailAddress);
        boolean isAccepted = orderingService.isAccepted();

        if (isAccepted) {
            orderReception.registerOrder(order);
            return new OrderDTO(order, name, true);
        } else {
            System.out.println("Order for " + order.getOrderedProduct().getName() + " from " + name +
                " REJECTED - note taken.");
            return new OrderDTO(order, name, false);
        }
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
