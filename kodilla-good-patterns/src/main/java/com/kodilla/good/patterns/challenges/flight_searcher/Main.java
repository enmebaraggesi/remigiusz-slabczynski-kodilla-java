package com.kodilla.good.patterns.challenges.flight_searcher;

public class Main {

    public static void main(String[] args) {

        Airport krakow = new Airport("Krakow", "KRK");
        Airport warsaw = new Airport("Warsaw", "WAW");
        Airport gdansk = new Airport("Gdansk", "GDN");
        Airport lodz = new Airport("Lodz", "LCJ");
        Airport katowice = new Airport("Katowice", "KTW");

        FlightMaintenance flightMaintenance = new FlightMaintenance();
        flightMaintenance.addFlight(krakow, warsaw);
        flightMaintenance.addFlight(krakow, lodz);
        flightMaintenance.addFlight(warsaw, gdansk);
        flightMaintenance.addFlight(warsaw, krakow);
        flightMaintenance.addFlight(warsaw, katowice);
        flightMaintenance.addFlight(lodz, gdansk);
        flightMaintenance.addFlight(lodz, warsaw);
        flightMaintenance.addFlight(gdansk, katowice);
        flightMaintenance.addFlight(gdansk, warsaw);
        flightMaintenance.addFlight(katowice, warsaw);

        SearchEngine searchEngine = new SearchEngine();
        searchEngine.updateFlights(flightMaintenance.getAvailableFlights());
        ResultWriter resultWriter = new ResultWriter(searchEngine);

        resultWriter.showAllFlightsFrom(warsaw);
        resultWriter.showAllFlightsTo(warsaw);
        resultWriter.showAllFlightsWithTransfer(krakow, lodz, gdansk);
        resultWriter.showAllFlightsWithTransfer(krakow, warsaw, lodz);
    }
}
