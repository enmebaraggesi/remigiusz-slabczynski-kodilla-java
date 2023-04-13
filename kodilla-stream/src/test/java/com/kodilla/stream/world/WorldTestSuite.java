package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {

        //Given
        World world = new World();
        Continent europe = new Continent();
        Country austria = new Country(new BigDecimal(8956000));
        Country bulgaria = new Country(new BigDecimal(6878000));
        Country czechRep = new Country(new BigDecimal(10510000));
        europe.addCountry(austria);
        europe.addCountry(bulgaria);
        europe.addCountry(czechRep);
        world.addContinent(europe);
        Continent asia = new Continent();
        Country china = new Country(new BigDecimal(1412000000));
        Country japan = new Country(new BigDecimal(125700000));
        Country sKorea = new Country(new BigDecimal(51740000));
        asia.addCountry(china);
        asia.addCountry(japan);
        asia.addCountry(sKorea);
        world.addContinent(asia);
        Continent africa = new Continent();
        Country chad = new Country(new BigDecimal(17180000));
        Country egypt = new Country(new BigDecimal(109300000));
        Country ghana = new Country(new BigDecimal(32830000));
        africa.addCountry(chad);
        africa.addCountry(egypt);
        africa.addCountry(ghana);
        world.addContinent(africa);

        //When
        BigDecimal expected = new BigDecimal("1775094000");
        BigDecimal result = world.getPeopleQuantity();

        //Then
        assertEquals(expected, result);
    }
}