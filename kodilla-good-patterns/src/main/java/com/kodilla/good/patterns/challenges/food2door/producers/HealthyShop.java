package com.kodilla.good.patterns.challenges.food2door.producers;

import com.kodilla.good.patterns.challenges.food2door.*;
import com.kodilla.good.patterns.challenges.food2door.communication.OrderingService;
import com.kodilla.good.patterns.challenges.food2door.database.OrderReception;

import java.util.List;

public class HealthyShop implements ProducerService {

    private final String name = "HealthyShop";
    private final String phoneNumber = "(+48) 608608608";
    private final String emailAddress = "healthy_shop@interia.pl";
    private final List<String> device = List.of("Delivery details handled via email " + emailAddress,
        "Delivery details handled via phone " + phoneNumber);

    private OrderingService orderingService1;
    private OrderingService orderingService2;
    private OrderReception orderReception;
    private Order order;

    public HealthyShop(OrderingService orderingService1, OrderingService orderingService2,
                       OrderReception orderReception, Order order) {
        this.orderingService1 = orderingService1;
        this.orderingService2 = orderingService2;
        this.orderReception = orderReception;
        this.order = order;
    }

    @Override
    public OrderDTO process() {
        orderingService1.sendOrder(order.getOrderNumber(), emailAddress);
        boolean isAccepted = orderingService1.isAccepted();
        int deviceFlag = 0;

        if (!isAccepted) {
            isAccepted = orderingService2.isAccepted();
            deviceFlag = 1;
        }

        if (isAccepted) {
            orderReception.registerOrder(order);
            System.out.println(device.get(deviceFlag));
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

    public String getEmailAddress() {
        return emailAddress;
    }
}
