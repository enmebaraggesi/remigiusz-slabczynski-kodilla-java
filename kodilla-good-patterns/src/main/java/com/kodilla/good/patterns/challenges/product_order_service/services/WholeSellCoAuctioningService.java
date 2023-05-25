package com.kodilla.good.patterns.challenges.product_order_service.services;

import com.kodilla.good.patterns.challenges.product_order_service.objects.Auction;

public class WholeSellCoAuctioningService implements AuctioningService {
    @Override
    public boolean isSold(Auction auction) {

        return auction.isPaymentConfirmed();
    }
}
