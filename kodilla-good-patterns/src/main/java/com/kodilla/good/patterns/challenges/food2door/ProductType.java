package com.kodilla.good.patterns.challenges.food2door;

public class ProductType {

    protected String name;
    protected String measuringUnit;
    protected double price;

    public ProductType(String name, String measuringUnit, double price) {
        this.name = name;
        this.measuringUnit = measuringUnit;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getMeasuringUnit() {
        return measuringUnit;
    }

    public double getPrice() {
        return price;
    }
}
