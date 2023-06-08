package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskFactoryTestSuite {

    @Test
    void testShoppingTaskCreationAndUsage() {

        //Given
        TaskFactory tested = new TaskFactory();

        //When
        Task shoppingTask = tested.createTask(TaskFactory.SHOPPING);
        shoppingTask.executeTask();

        //Then
        assertEquals("Shopping Task", shoppingTask.getTaskName());
        assertTrue(shoppingTask.isTaskExecuted());
    }

    @Test
    void testPaintingTaskCreationAndUsage() {

        //Given
        TaskFactory tested = new TaskFactory();

        //When
        Task paintingTask = tested.createTask(TaskFactory.PAINTING);
        paintingTask.executeTask();

        //Then
        assertEquals("Painting Task", paintingTask.getTaskName());
        assertTrue(paintingTask.isTaskExecuted());
    }

    @Test
    void testDrivingTaskCreationAndUsage() {

        //Given
        TaskFactory tested = new TaskFactory();

        //When
        Task drivingTask = tested.createTask(TaskFactory.DRIVING);
        drivingTask.executeTask();

        //Then
        assertEquals("Driving Task", drivingTask.getTaskName());
        assertTrue(drivingTask.isTaskExecuted());
    }
}