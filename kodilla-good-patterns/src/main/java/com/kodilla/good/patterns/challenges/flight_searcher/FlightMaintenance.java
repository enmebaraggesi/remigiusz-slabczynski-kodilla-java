package com.kodilla.good.patterns.challenges.flight_searcher;

import java.util.*;

public class FlightMaintenance {

    private final Map<Airport, Set<Airport>> availableFlights;

    public FlightMaintenance() {
        this.availableFlights = new HashMap<>();
    }

    public void addFlight(Airport departure, Airport destination) {

        if (availableFlights.containsKey(departure)) {
            availableFlights.get(departure).add(destination);
        } else {
            availableFlights.put(departure, new HashSet<>(Set.of(destination)));
        }
    }

    public Map<Airport, Set<Airport>> getAvailableFlights() {
        return availableFlights;
    }
}
