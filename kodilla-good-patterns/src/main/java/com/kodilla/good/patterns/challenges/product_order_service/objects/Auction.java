package com.kodilla.good.patterns.challenges.product_order_service.objects;

import java.time.LocalDateTime;

public class Auction {

    private Item auctionedItem;
    private User buyer;
    private LocalDateTime dateBought;
    private boolean paymentConfirmed;

    public Auction(Item auctionedItem, User buyer, boolean paymentConfirmed) {
        this.auctionedItem = auctionedItem;
        this.buyer = buyer;
        this.dateBought = LocalDateTime.now();
        this.paymentConfirmed = paymentConfirmed;
    }

    public Item getAuctionedItem() {
        return auctionedItem;
    }

    public User getBuyer() {
        return buyer;
    }

    public LocalDateTime getDateBought() {
        return dateBought;
    }

    public boolean isPaymentConfirmed() {
        return paymentConfirmed;
    }
}
