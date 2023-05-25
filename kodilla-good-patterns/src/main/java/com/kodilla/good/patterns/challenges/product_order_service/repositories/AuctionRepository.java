package com.kodilla.good.patterns.challenges.product_order_service.repositories;

import com.kodilla.good.patterns.challenges.product_order_service.objects.Auction;

import java.util.List;

import static com.kodilla.good.patterns.challenges.product_order_service.repositories.ItemRepository.ITEM_MAP;
import static com.kodilla.good.patterns.challenges.product_order_service.repositories.UserRepository.USER_MAP;

public class AuctionRepository {

    List<Auction> auctionList;

    public AuctionRepository() {
        this.auctionList = List.of(
                new Auction(ITEM_MAP.get(1), USER_MAP.get(1), true),
                new Auction(ITEM_MAP.get(2), USER_MAP.get(2), true),
                new Auction(ITEM_MAP.get(3), USER_MAP.get(3), false),
                new Auction(ITEM_MAP.get(4), USER_MAP.get(4), true)
        );
    }

    public List<Auction> getAuctionList() {
        return auctionList;
    }
}
