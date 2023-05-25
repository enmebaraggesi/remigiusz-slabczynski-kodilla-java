package com.kodilla.good.patterns.challenges.product_order_service.services;

import com.kodilla.good.patterns.challenges.product_order_service.objects.Auction;

public interface AuctioningService {

    boolean isSold(Auction auction);
}
