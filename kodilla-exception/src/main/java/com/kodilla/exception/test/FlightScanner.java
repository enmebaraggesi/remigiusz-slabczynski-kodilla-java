package com.kodilla.exception.test;

import java.util.Map;

public class FlightScanner {

    private Map<String, Boolean> availableAirports;

    public FlightScanner() {
        this.availableAirports = Map.of(
            "Madrid", true,
            "Warsaw", true,
            "Stockholm", true,
            "Helsinki", true,
            "Berlin", false
        );
    }

    public void findFlight(Flight flight) throws RouteNotFoundException {

        String arrival = flight.getArrivalAirport();
        String departure = flight.getDepartureAirport();

        if (!availableAirports.containsKey(arrival) ||
            !availableAirports.containsKey(departure)) {
            throw new RouteNotFoundException("such flight doesn't exist in our database.");
        } else if (!availableAirports.get(arrival) ||
            !availableAirports.get(departure)) {
            throw new RouteNotFoundException("flight is not handled right now.");
        } else {
            System.out.println("Your flight from " + departure +
                " to " + arrival + " is available.");
        }
    }
}
