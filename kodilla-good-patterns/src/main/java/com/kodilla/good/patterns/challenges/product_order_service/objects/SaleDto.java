package com.kodilla.good.patterns.challenges.product_order_service.objects;

import java.time.LocalDateTime;

public class SaleDto {

    private User user;
    private Item item;
    private LocalDateTime date;
    private boolean confirmed;

    public SaleDto(Auction auction, boolean confirmed) {
        this.user = auction.getBuyer();
        this.item = auction.getAuctionedItem();
        this.date = auction.getDateBought();
        this.confirmed = confirmed;
        System.out.println("New SaleDto created\n");
    }

    public User getUser() {
        return user;
    }

    public Item getItem() {
        return item;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public boolean isConfirmed() {
        return confirmed;
    }
}
