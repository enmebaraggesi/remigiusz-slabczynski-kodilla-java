package com.kodilla.good.patterns.challenges.product_order_service.services;

import com.kodilla.good.patterns.challenges.product_order_service.objects.User;

public interface ConfirmationSender {

    void sendConfirmation(User user);
}
