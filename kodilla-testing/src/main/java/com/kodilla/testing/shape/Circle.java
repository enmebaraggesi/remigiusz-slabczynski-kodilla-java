package com.kodilla.testing.shape;

public class Circle implements Shape {

    String shapeName = "Circle";
    double fieldInSqCm = 201.06;
    @Override
    public String getShapeName() {
        return shapeName;
    }

    @Override
    public double getField() {
        return fieldInSqCm;
    }
}
