package com.kodilla.good.patterns.challenges.product_order_service.repositories;

import com.kodilla.good.patterns.challenges.product_order_service.objects.Item;

import java.util.Map;

public class ItemRepository {

    public static final Map<Integer, Item> ITEM_MAP = Map.of(
            1, new Item("kapcie", 1234),
            2, new Item("szczoteczka do zębów", 4321),
            3, new Item("kapusta", 1212),
            4, new Item("samolot", 3434)
    );
}
