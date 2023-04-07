package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {

    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {

        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
            temperatures.getTemperatures().entrySet()) {

            //adding 1 Celsius degree to current value
            //as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double calculateMediumTemperature() {

        double tempSum = 0.0;

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            tempSum += temperature.getValue();
        }
        return tempSum / temperatures.getTemperatures().size();
    }

    public double calculateTemperaturesMedian() {

        List<Double> tempList = new ArrayList<>();
        double median;
        int middleIndex = temperatures.getTemperatures().size() / 2;

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            tempList.add(temperature.getValue());
        }

        Collections.sort(tempList);

        if (temperatures.getTemperatures().size() % 2 == 0) {
            median = (tempList.get(middleIndex - 1) + tempList.get(middleIndex)) / 2;
        } else {
            median = tempList.get(middleIndex);
        }
        return median;
    }
}
