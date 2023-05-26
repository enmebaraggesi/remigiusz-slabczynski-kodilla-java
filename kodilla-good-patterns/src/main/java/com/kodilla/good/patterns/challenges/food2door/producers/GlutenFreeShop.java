package com.kodilla.good.patterns.challenges.food2door.producers;

import com.kodilla.good.patterns.challenges.food2door.*;
import com.kodilla.good.patterns.challenges.food2door.communication.OrderingService;
import com.kodilla.good.patterns.challenges.food2door.database.*;

public class GlutenFreeShop implements ProducerService {

    private final String name = "GlutenFreeShop";
    private final String phoneNumber = "(+34) 908687576";

    private OrderingService orderingService;
    private OrderReception orderReception;
    private TransitService transitService;
    private Order order;

    public GlutenFreeShop(OrderingService orderingService, OrderReception orderReception,
                          TransitService transitService, Order order) {
        this.orderingService = orderingService;
        this.orderReception = orderReception;
        this.transitService = transitService;
        this.order = order;
    }

    @Override
    public OrderDTO process() {

        boolean permitGiven = transitService.getPermit();
        boolean isAccepted = false;
        if (permitGiven) {
            orderingService.sendOrder(order.getOrderNumber(), phoneNumber);
            isAccepted = orderingService.isAccepted();
        }

        if (isAccepted) {
            orderReception.registerOrder(order);
            System.out.println("Permit for transit obtained.");
            return new OrderDTO(order, name, true);
        } else {
            return new OrderDTO(order, name, false);
        }
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
