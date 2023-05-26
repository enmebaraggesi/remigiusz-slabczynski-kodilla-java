package com.kodilla.good.patterns.challenges.food2door;

import com.kodilla.good.patterns.challenges.food2door.communication.*;
import com.kodilla.good.patterns.challenges.food2door.database.*;
import com.kodilla.good.patterns.challenges.food2door.producers.*;

public class Main {

    public static void main(String[] args) {

        ProductType orange = new ProductType("orange", "pc", 0.54);
        ProductType rice = new ProductType("wheat", "kg", 4.79);
        ProductType tofu = new ProductType("tofu", "kg", 0.69);
        ProducerService extraFoodShop = new ExtraFoodShop(new EmailCommunication(), new OrderRepository(),
            new Order(1234, 120.0, orange));
        ProducerService glutenFreeShop = new GlutenFreeShop(new SmsCommunication(), new OrderRepository(),
            new FrancePermit(), new Order(1235, 100.0, rice));
        ProducerService healthyShop = new HealthyShop(new EmailCommunication(),
            new SmsCommunication(), new OrderRepository(),
            new Order(1236, 0.25, tofu));

        OrderDTO order1234 = extraFoodShop.process();
        OrderDTO order1235 = glutenFreeShop.process();
        OrderDTO order1236 = healthyShop.process();
    }
}
