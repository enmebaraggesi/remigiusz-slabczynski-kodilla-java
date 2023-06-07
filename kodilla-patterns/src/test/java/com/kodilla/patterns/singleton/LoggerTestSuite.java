package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoggerTestSuite {

    private static Logger logger1;

    @BeforeAll
    public static void createLoggerWithLog() {
        logger1 = Logger.INSTANCE;
        logger1.log("first log");
    }

    @Test
    void givenSecondLoggerReference_bothShouldBeEqual() {
        //GIVEN
        Logger logger2 = Logger.INSTANCE;
        //WHEN
        //THEN
        assertEquals(logger1, logger2);
    }

    @Test
    void whenNewLogAdded_shouldReadLastLogCorrectly() {
        //GIVEN
        //WHEN
        logger1.log("second log");
        String result = logger1.getLastLog();
        //THEN
        assertEquals("second log", result);
    }
}