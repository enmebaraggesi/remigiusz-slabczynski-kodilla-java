package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuite {

    private Map<String, Double> temperaturesMap = new HashMap<>();
    @Mock
    private Temperatures temperaturesMock;

    @BeforeEach
    void beforeAll() {
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);
    }

    @Test
    void testCalculateForecastWithMock() {

        //Given
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }

    @Test
    void testCalculateMediumTemperatureWithMock() {

        //Given
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double expected = 25.56;
        double result = weatherForecast.calculateMediumTemperature();

        //Then
        Assertions.assertEquals(expected, result);

    }

    @Test
    void testCalculateTemperaturesMedianWithMock() {

        //Given
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double expected = 25.5;
        double result = weatherForecast.calculateTemperaturesMedian();

        //Then
        Assertions.assertEquals(expected, result);
    }
}
