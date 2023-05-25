package com.kodilla.good.patterns.challenges.product_order_service.services;

import com.kodilla.good.patterns.challenges.product_order_service.objects.User;

public class SmsConfirmationSender implements ConfirmationSender {
    @Override
    public void sendConfirmation(User user) {
        System.out.println("SMS sent to " + user.getName() + " " + user.getSurname());
    }
}
