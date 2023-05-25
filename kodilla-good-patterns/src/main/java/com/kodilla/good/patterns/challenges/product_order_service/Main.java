package com.kodilla.good.patterns.challenges.product_order_service;

import com.kodilla.good.patterns.challenges.product_order_service.objects.Auction;
import com.kodilla.good.patterns.challenges.product_order_service.repositories.AuctionRepository;
import com.kodilla.good.patterns.challenges.product_order_service.repositories.WholeSellCoSalesRecorder;
import com.kodilla.good.patterns.challenges.product_order_service.services.ProductOrderService;
import com.kodilla.good.patterns.challenges.product_order_service.services.SmsConfirmationSender;
import com.kodilla.good.patterns.challenges.product_order_service.services.WholeSellCoAuctioningService;

public class Main {

    public static void main(String[] args) {

        AuctionRepository auctionRepository = new AuctionRepository();
        ProductOrderService productOrderService = new ProductOrderService(
                new WholeSellCoAuctioningService(),
                new WholeSellCoSalesRecorder(),
                new SmsConfirmationSender()
        );

        for (Auction auction : auctionRepository.getAuctionList()) {
            productOrderService.processAuctionSale(auction);
        }
    }
}
