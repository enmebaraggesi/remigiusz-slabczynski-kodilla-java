package com.kodilla.exception.test;

public class FlightScannerRunner {

    public static void main(String[] args) {

        FlightScanner flightScanner = new FlightScanner();

        Flight flightIsAvailable = new Flight("Madrid", "Helsinki");
        Flight flightIsUnavailable = new Flight("Warsaw", "Berlin");
        Flight flightDoesntExist = new Flight("Stockholm", "Budapest");

        try {
            flightScanner.findFlight(flightIsAvailable);
        } catch (RouteNotFoundException e) {
            System.out.println("We are sorry, " + e.getMessage());
        }

        try {
            flightScanner.findFlight(flightIsUnavailable);
        } catch (RouteNotFoundException e) {
            System.out.println("We are sorry, " + e.getMessage());
        }

        try {
            flightScanner.findFlight(flightDoesntExist);
        } catch (RouteNotFoundException e) {
            System.out.println("We are sorry, " + e.getMessage());
        }
    }
}