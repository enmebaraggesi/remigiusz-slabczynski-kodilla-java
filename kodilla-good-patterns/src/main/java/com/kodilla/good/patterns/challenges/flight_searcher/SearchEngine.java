package com.kodilla.good.patterns.challenges.flight_searcher;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {

    private Map<Airport, Set<Airport>> flights = new HashMap<>();

    public String collectResultsFrom(Airport departure) {

        return flights.entrySet().stream()
            .filter(entry -> entry.getKey().equals(departure))
            .flatMap(entry -> entry.getValue().stream())
            .map(airport -> airport.getName() + " [" + airport.getIataCode() + "]")
            .collect(Collectors.joining(", "));
    }

    public String collectResultsTo(Airport destination) {

        return flights.entrySet().stream()
            .filter(entry -> entry.getValue().contains(destination))
            .map(Map.Entry::getKey)
            .map(airport -> airport.getName() + " [" + airport.getIataCode() + "]")
            .collect(Collectors.joining(", "));
    }

    public long collectResultsWithTransfer(Airport departure, Airport transfer, Airport destination) {

        long result = flights.entrySet().stream()
            .filter(entry -> entry.getKey().equals(departure))
            .flatMap(entry -> entry.getValue().stream())
            .filter(airport -> airport.equals(transfer))
            .count();

        if (result > 0) {
            return flights.entrySet().stream()
                .filter(entry -> entry.getKey().equals(transfer))
                .flatMap(entry -> entry.getValue().stream())
                .filter(airport -> airport.equals(destination))
                .count();
        } else {
            return result;
        }
    }

    public void updateFlights(Map<Airport, Set<Airport>> flights) {
        this.flights = flights;
    }
}
