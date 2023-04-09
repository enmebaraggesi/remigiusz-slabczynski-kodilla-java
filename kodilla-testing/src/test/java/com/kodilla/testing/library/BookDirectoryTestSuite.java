package com.kodilla.testing.library;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookDirectoryTestSuite {

    private List<Book> generateListOfBooks(int booksQuantity) {

        List<Book> resultList = new ArrayList<>();
        for (int i = 1; i <= booksQuantity; i++) {

            Book theBook = new Book("Title " + i, "Author " + i, 1970 + i);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Mock
    private LibraryDatabase libraryDatabaseMock;

    @Nested
    @DisplayName("Testing listBooksWithCondition method")
    class ListBooksWith {

        @Test
        void testListBooksWithConditionReturnList() {

            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOfBooks = new ArrayList<>();
            Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
            Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
            Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
            Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
            resultListOfBooks.add(book1);
            resultListOfBooks.add(book2);
            resultListOfBooks.add(book3);
            resultListOfBooks.add(book4);
            when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

            //When
            List<Book> theListOfBooks = bookLibrary.listBookWithCondition("Secret");

            //Then
            assertEquals(4, theListOfBooks.size());
        }

        @Test
        void testListBooksWithConditionMoreThan20() {

            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOf0Books = new ArrayList<>();
            List<Book> resultListOf15Books = generateListOfBooks(15);
            List<Book> resultListOf40Books = generateListOfBooks(40);
            when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
            when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
            when(libraryDatabaseMock.listBooksWithCondition("FortyBooks")).thenReturn(resultListOf40Books);

            //When
            List<Book> theListOfBooks0 = bookLibrary.listBookWithCondition("ZeroBooks");
            List<Book> theListOfBooks15 = bookLibrary.listBookWithCondition("Any title");
            List<Book> theListOfBooks40 = bookLibrary.listBookWithCondition("FortyBooks");

            //Then
            assertEquals(0, theListOfBooks0.size());
            assertEquals(15, theListOfBooks15.size());
            assertEquals(0, theListOfBooks40.size());
        }

        @Test
        void testListBooksWithConditionFragmentShorterThan3() {

            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

            //When
            List<Book> theListOfBooks10 = bookLibrary.listBookWithCondition("An");

            //Then
            assertEquals(0, theListOfBooks10.size());
            verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
        }
    }

    @Nested
    @DisplayName("Testing listBooksInHandsOf method")
    class ListBooksInHands {

        @Test
        void testListBooksInHandsOfNumBooksBorrowed() {

            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOf0Books = new ArrayList<>();
            List<Book> resultListOf1Book = generateListOfBooks(1);
            List<Book> resultListOf5Books = generateListOfBooks(5);
            LibraryUser user0 = new LibraryUser("User0", "Zero", "0000");
            LibraryUser user1 = new LibraryUser("User1", "One", "1111");
            LibraryUser user5 = new LibraryUser("User5", "Five", "5555");
            when(libraryDatabaseMock.listBooksInHandsOf(user0)).thenReturn(resultListOf0Books);
            when(libraryDatabaseMock.listBooksInHandsOf(user1)).thenReturn(resultListOf1Book);
            when(libraryDatabaseMock.listBooksInHandsOf(user5)).thenReturn(resultListOf5Books);

            //When
            List<Book> theListOf0Books = bookLibrary.listBooksInHandsOf(user0);
            List<Book> theListOf1Book = bookLibrary.listBooksInHandsOf(user1);
            List<Book> theListOf5Books = bookLibrary.listBooksInHandsOf(user5);

            //Then
            assertEquals(0, theListOf0Books.size());
            assertEquals(1, theListOf1Book.size());
            assertEquals(5, theListOf5Books.size());
        }
    }
}
