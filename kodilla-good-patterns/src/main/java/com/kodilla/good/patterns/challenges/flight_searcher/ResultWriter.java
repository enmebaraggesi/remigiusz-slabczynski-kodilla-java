package com.kodilla.good.patterns.challenges.flight_searcher;

public class ResultWriter {

    private final SearchEngine searchEngine;

    public ResultWriter(SearchEngine searchEngine) {
        this.searchEngine = searchEngine;
    }

    public void showAllFlightsFrom(String departure) {

        String result = searchEngine.collectResultsFrom(departure);

        if (result == null) {
            System.out.println("There is no flight available");
        } else {
            System.out.println("Available flights from " + departure + ": " + result);
        }
    }

    public void showAllFlightsTo(String destination) {

        String result = searchEngine.collectResultsTo(destination);

        if (result == null) {
            System.out.println("There is no flight available");
        } else {
            System.out.println("Available flights to " + destination + ": " + result);
        }
    }

    public void showAllFlightsWithTransfer(String departure, String transfer, String destination) {

        long result = searchEngine.collectResultsWithTransfer(departure, transfer, destination);

        if (result == 0) {
            System.out.println("There is no flight available");
        } else {
            System.out.println("There is " + result + " available flight(s) from " + departure
                + ", by " + transfer + " to " + destination);
        }
    }
}
