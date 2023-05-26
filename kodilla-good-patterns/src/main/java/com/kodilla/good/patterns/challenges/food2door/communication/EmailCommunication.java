package com.kodilla.good.patterns.challenges.food2door.communication;

public class EmailCommunication implements OrderingService {

    @Override
    public void sendOrder(int orderNumber, String emailAddress) {
        System.out.println("Sent order " + orderNumber + " to '" + emailAddress + "'.");
    }

    @Override
    public boolean isAccepted() {
        return true;
    }
}
