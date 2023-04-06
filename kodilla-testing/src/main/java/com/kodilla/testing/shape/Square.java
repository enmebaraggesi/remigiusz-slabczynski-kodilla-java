package com.kodilla.testing.shape;

public class Square implements Shape {

    String shapeName = "Square";
    double fieldInSqCm = 20;

    @Override
    public String getShapeName() {
        return shapeName;
    }

    @Override
    public double getField() {
        return fieldInSqCm;
    }
}
