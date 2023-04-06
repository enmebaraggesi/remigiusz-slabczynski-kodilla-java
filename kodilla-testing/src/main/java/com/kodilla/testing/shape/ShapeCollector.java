package com.kodilla.testing.shape;

import java.util.*;

public class ShapeCollector {

    private List<Shape> shapeCollection;

    public ShapeCollector() {
        shapeCollection = new ArrayList<>();
    }

    public void addFigure(Shape shape) {

        shapeCollection.add(shape);
    }

    public void removeFigure(Shape shape) {

        shapeCollection.remove(shape);
    }

    public Shape getFigure(int n) {

        if (n < 0 || n >= shapeCollection.size()) {
            return null;
        }
        return shapeCollection.get(n);
    }

    public String showFigures() {

        String showFigures = "";
        for (int i = 0; i < shapeCollection.size(); i++) {
            Shape shape = shapeCollection.get(i);
            if (i < shapeCollection.size() - 1) {
                showFigures += shape.getShapeName() + ", ";
            } else {
                showFigures += shape.getShapeName();
            }
        }
        return showFigures;
    }

    public List<Shape> getShapeCollection() {

        return shapeCollection;
    }
}
