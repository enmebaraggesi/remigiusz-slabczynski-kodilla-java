package com.kodilla.spring.library;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LibraryTestSuite {

    @Autowired
    private Library library;

    @Test
    void testSaveToDb() {

        //Given
//        ApplicationContext context =
//            new AnnotationConfigApplicationContext("com.kodilla.spring");
//        Library library = context.getBean(Library.class);

        //When
        library.saveToDb();

        //Then
        //do nothing
    }

    @Test
    void testLoadFromDb() {

        //Given
//        ApplicationContext context =
//            new AnnotationConfigApplicationContext("com.kodilla.spring");
//        Library library = context.getBean(Library.class);

        //When
        library.loadFromDb();

        //Then
        //do nothing
    }
}