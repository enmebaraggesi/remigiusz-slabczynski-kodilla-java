package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ShapeCollectorTestSuite {

    @Nested
    @DisplayName("Operations on collection tests")
    class OperationTests {

        @Test
        void addFigureTest() {

            //Given
            Shape circle = new Circle();
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            shapeCollector.addFigure(circle);

            //Then
            assertEquals(1, shapeCollector.getShapeCollection().size());
        }

        @Test
        void removeFigureTest() {

            //Given
            Shape circle = new Circle();
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(circle);

            //When
            shapeCollector.removeFigure(circle);

            //Then
            assertEquals(0, shapeCollector.getShapeCollection().size());
        }

    }

    @Nested
    @DisplayName("Receiving info from collection tests")
    class ReceivingTests {

        @Test
        void getFigureTest() {

            //Given
            Shape circle = new Circle();
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(circle);

            //When
            Shape result = shapeCollector.getFigure(0);

            //Then
            assertEquals(circle, result);
        }

        @Test
        void getFigureLowerBoundaryTest() {

            //Given
            Shape circle = new Circle();
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(circle);

            //When
            Shape result = shapeCollector.getFigure(-1);

            //Then
            assertNull(result);
        }

        @Test
        void getFigureUpperBoundaryTest() {

            //Given
            Shape circle = new Circle();
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(circle);

            //When
            Shape result = shapeCollector.getFigure(1);

            //Then
            assertNull(result);
        }

        @Test
        void showFiguresTest() {

            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(new Circle());
            shapeCollector.addFigure(new Triangle());
            shapeCollector.addFigure(new Square());

            //When
            String collection = "Circle, Triangle, Square";
            String result = shapeCollector.showFigures();

            //Then
            assertEquals(collection, result);
        }
    }
}
