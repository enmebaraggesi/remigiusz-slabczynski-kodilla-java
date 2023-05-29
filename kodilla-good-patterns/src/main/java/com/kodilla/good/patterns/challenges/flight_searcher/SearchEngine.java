package com.kodilla.good.patterns.challenges.flight_searcher;

import java.util.stream.Collectors;

public class SearchEngine {

    private FlightMaintenance flights;

    public SearchEngine(FlightMaintenance fights) {
        this.flights = fights;
    }

    public String collectResultsFrom(String departure) {

        return flights.getAvailableFlights().stream()
            .filter(flight -> flight.getFrom().equals(departure))
            .map(Flight::getTo)
            .collect(Collectors.joining(", "));
    }

    public String collectResultsTo(String destination) {

        return flights.getAvailableFlights().stream()
            .filter(flight -> flight.getTo().equals(destination))
            .map(Flight::getFrom)
            .collect(Collectors.joining(", "));
    }

    public long collectResultsWithTransfer(String departure, String transfer, String destination) {

        long result = flights.getAvailableFlights().stream()
            .filter(flight -> flight.getFrom().equals(departure))
            .filter(flight -> flight.getTo().equals(transfer))
            .count();

        if (result > 0) {
            return flights.getAvailableFlights().stream()
                .filter(flight -> flight.getFrom().equals(transfer))
                .filter(flight -> flight.getTo().equals(destination))
                .count();
        } else {
            return result;
        }
    }
}
