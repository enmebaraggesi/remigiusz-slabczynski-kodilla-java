package com.kodilla.good.patterns.challenges.product_order_service.services;

import com.kodilla.good.patterns.challenges.product_order_service.objects.Auction;
import com.kodilla.good.patterns.challenges.product_order_service.objects.SaleDto;

public class ProductOrderService {

    private AuctioningService auctioningService;
    private SalesRecorder salesRecorder;
    private ConfirmationSender confirmationSender;

    public ProductOrderService(AuctioningService auctioningService, SalesRecorder salesRecorder,
                               ConfirmationSender confirmationSender) {
        this.auctioningService = auctioningService;
        this.salesRecorder = salesRecorder;
        this.confirmationSender = confirmationSender;
    }

    public SaleDto processAuctionSale(Auction auction) {

        boolean sold = auctioningService.isSold(auction);

        if (sold) {
            confirmationSender.sendConfirmation(auction.getBuyer());
            salesRecorder.registerSale(auction);
            return new SaleDto(auction, true);
        } else {
            return new SaleDto(auction, false);
        }
    }
}
