package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {

    public final static String SHOPPING = "SHOPPING";
    public final static String PAINTING = "PAINTING";
    public final static String DRIVING = "DRIVING";

    public Task createTask(String typeOfTask) {

        return switch (typeOfTask) {
            case "SHOPPING" -> new ShoppingTask("Shopping Task", "pencil", 2);
            case "PAINTING" -> new PaintingTask("Painting Task", "red", "house");
            case "DRIVING" -> new DrivingTask("Driving Task", "bank", "bicycle");
            default -> null;
        };
    }
}
