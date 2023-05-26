package com.kodilla.good.patterns.challenges.food2door.communication;

public class SmsCommunication implements OrderingService {


    @Override
    public void sendOrder(int orderNumber, String phoneNumber) {
        System.out.println("Sent order " + orderNumber + " to '" + phoneNumber + "'.");
    }

    @Override
    public boolean isAccepted() {
        return true;
    }
}
