package com.kodilla.testing.shape;

public class Triangle implements Shape {

    String shapeName = "Triangle";
    double fieldInSqCm = 54;

    @Override
    public String getShapeName() {
        return shapeName;
    }

    @Override
    public double getField() {
        return fieldInSqCm;
    }
}
