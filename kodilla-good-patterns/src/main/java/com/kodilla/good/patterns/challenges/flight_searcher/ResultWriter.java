package com.kodilla.good.patterns.challenges.flight_searcher;

public class ResultWriter {

    private final SearchEngine searchEngine;

    public ResultWriter(SearchEngine searchEngine) {
        this.searchEngine = searchEngine;
    }

    public void showAllFlightsFrom(Airport departure) {

        String result = searchEngine.collectResultsFrom(departure);

        if (result == null) {
            System.out.println("There is no flight available");
        } else {
            System.out.println("Available flights from "
                + departure.getName() + " [" + departure.getIataCode() + "]: "
                + result);
        }
    }

    public void showAllFlightsTo(Airport destination) {

        String result = searchEngine.collectResultsTo(destination);

        if (result == null) {
            System.out.println("There is no flight available");
        } else {
            System.out.println("Available flights to "
                + destination.getName() + " [" + destination.getIataCode() + "]: "
                + result);
        }
    }

    public void showAllFlightsWithTransfer(Airport departure, Airport transfer, Airport destination) {

        long result = searchEngine.collectResultsWithTransfer(departure, transfer, destination);

        if (result == 0) {
            System.out.println("There is no flight available");
        } else {
            System.out.println("There is " + result + " available flight from "
                + departure.getName() + " [" + departure.getIataCode() + "], by "
                + transfer.getName() + " [" + transfer.getIataCode() + "] to "
                + destination.getName() + " [" + departure.getIataCode() + "]");
        }
    }
}
