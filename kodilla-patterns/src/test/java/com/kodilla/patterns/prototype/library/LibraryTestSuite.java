package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTestSuite {

    @Test
    void testGetBooks() {

        //Given
        Library originalLibrary = new Library("Library ver1");
        Set<Book> books = new HashSet<>();
        Book book1 = new Book("Book1", "Author1", LocalDate.now());
        books.add(book1);
        Book book2 = new Book("Book2", "Author2", LocalDate.now());
        books.add(book2);
        Book book3 = new Book("Book3", "Author3", LocalDate.now());
        books.add(book3);
        originalLibrary.setBooks(books);

        //When
        Library shallowCopyLibrary;
        try {
            shallowCopyLibrary = originalLibrary.shallowCopy("Library ver2");
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        Library deepCopyLibrary;
        try {
            deepCopyLibrary = originalLibrary.deepCopy("Library ver3");
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        originalLibrary.getBooks().remove(book3);

        //Then
        assertEquals(2, originalLibrary.getBooks().size());
        assertEquals(2, shallowCopyLibrary.getBooks().size());
        assertEquals(3, deepCopyLibrary.getBooks().size());
        assertEquals(shallowCopyLibrary.getBooks(), originalLibrary.getBooks());
        assertNotEquals(deepCopyLibrary.getBooks(), originalLibrary.getBooks());
    }
}