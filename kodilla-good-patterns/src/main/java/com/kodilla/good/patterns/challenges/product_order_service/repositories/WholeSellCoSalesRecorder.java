package com.kodilla.good.patterns.challenges.product_order_service.repositories;

import com.kodilla.good.patterns.challenges.product_order_service.objects.Auction;
import com.kodilla.good.patterns.challenges.product_order_service.services.SalesRecorder;

public class WholeSellCoSalesRecorder implements SalesRecorder {
    @Override
    public void registerSale(Auction auction) {

        System.out.println("Auction with product number " + auction.getAuctionedItem().getItemSerialNumber() +
                " finished " + auction.getDateBought() + " is registered.");
    }
}
