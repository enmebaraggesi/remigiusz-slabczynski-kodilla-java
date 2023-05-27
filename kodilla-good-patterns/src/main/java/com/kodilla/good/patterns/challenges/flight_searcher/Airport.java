package com.kodilla.good.patterns.challenges.flight_searcher;

import java.util.Objects;

public class Airport {

    private final String name;
    private final String iataCode;

    public Airport(String name, String iataCode) {
        this.name = name;
        this.iataCode = iataCode;
    }

    public String getName() {
        return name;
    }

    public String getIataCode() {
        return iataCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airport airport = (Airport) o;

        if (!Objects.equals(name, airport.name)) return false;
        return Objects.equals(iataCode, airport.iataCode);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (iataCode != null ? iataCode.hashCode() : 0);
        return result;
    }
}
