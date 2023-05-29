package com.kodilla.good.patterns.challenges.flight_searcher;

public class Main {

    public static void main(String[] args) {

        Flight krakowWarsaw = new Flight("Krakow", "Warsaw");
        Flight krakowWarsaw2 = new Flight("Krakow", "Warsaw");
        Flight krakowLodz = new Flight("Krakow", "Lodz");
        Flight warsawGdansk = new Flight("Warsaw", "Gdansk");
        Flight warsawKrakow = new Flight("Warsaw", "Krakow");
        Flight warsawKatowice = new Flight("Warsaw", "Katowice");
        Flight lodzGdansk = new Flight("Lodz", "Gdansk");
        Flight lodzWarsaw = new Flight("Lodz", "Warsaw");
        Flight gdanskWarsaw = new Flight("Gdansk", "Warsaw");
        Flight katowiceWarsaw = new Flight("Katowice", "Warsaw");

        FlightMaintenance flightMaintenance = new FlightMaintenance();
        flightMaintenance.addFlight(krakowWarsaw);
        flightMaintenance.addFlight(krakowWarsaw2);
        flightMaintenance.addFlight(krakowLodz);
        flightMaintenance.addFlight(warsawGdansk);
        flightMaintenance.addFlight(warsawKrakow);
        flightMaintenance.addFlight(warsawKatowice);
        flightMaintenance.addFlight(lodzGdansk);
        flightMaintenance.addFlight(lodzWarsaw);
        flightMaintenance.addFlight(gdanskWarsaw);
        flightMaintenance.addFlight(katowiceWarsaw);

        SearchEngine searchEngine = new SearchEngine(flightMaintenance);
        ResultWriter resultWriter = new ResultWriter(searchEngine);

        resultWriter.showAllFlightsFrom("Warsaw");
        resultWriter.showAllFlightsTo("Warsaw");
        resultWriter.showAllFlightsWithTransfer("Krakow", "Lodz", "Gdansk");
        resultWriter.showAllFlightsWithTransfer("Krakow", "Warsaw", "Lodz");
    }
}
