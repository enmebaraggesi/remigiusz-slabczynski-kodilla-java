package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.*;

public class World {

    private final List<Continent> continents = new ArrayList<>();

    public void addContinent(Continent continent) {
        continents.add(continent);
    }

    public BigDecimal getPeopleQuantity() {

        return continents.stream()
            .flatMap(continent -> continent.getCountries().stream())
            .map(country -> country.getPeopleQuantity())
            .reduce(BigDecimal.ZERO, (sum, current) -> sum.add(current));
    }

    public List<Continent> getContinents() {
        return continents;
    }
}
