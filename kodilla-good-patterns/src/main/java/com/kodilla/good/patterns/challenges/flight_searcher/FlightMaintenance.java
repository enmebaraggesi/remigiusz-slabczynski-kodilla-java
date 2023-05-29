package com.kodilla.good.patterns.challenges.flight_searcher;

import java.util.*;

public class FlightMaintenance {

    private final Set<Flight> availableFlights;

    public FlightMaintenance() {
        this.availableFlights = new HashSet<>();
    }

    public void addFlight(Flight flight) {

        if (availableFlights.add(flight)) {
            System.out.println("Flight successfully added");
        } else {
            System.out.println("Flight already exists");
        }
    }

    public Set<Flight> getAvailableFlights() {
        return availableFlights;
    }
}
