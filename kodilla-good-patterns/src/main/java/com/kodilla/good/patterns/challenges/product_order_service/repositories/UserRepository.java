package com.kodilla.good.patterns.challenges.product_order_service.repositories;

import com.kodilla.good.patterns.challenges.product_order_service.objects.User;

import java.util.Map;

public class UserRepository {

    public final static Map<Integer, User> USER_MAP = Map.of(
            1, new User("Jan", "Janecki"),
            2, new User("Jerzy", "Jurek"),
            3, new User("Waldemar", "Walduś"),
            4, new User("Anna", "Aneczko")
    );

}
