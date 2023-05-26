package com.kodilla.good.patterns.challenges.food2door.communication;

public interface OrderingService {

    void sendOrder(int orderNumber, String emailAddress);

    boolean isAccepted();
}
