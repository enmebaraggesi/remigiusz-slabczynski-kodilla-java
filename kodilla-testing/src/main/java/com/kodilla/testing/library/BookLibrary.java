package com.kodilla.testing.library;

import java.util.*;

public class BookLibrary {

    private LibraryDatabase libraryDatabase;

    public BookLibrary(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }

    public List<Book> listBookWithCondition(String titleFragment) {
        List<Book> bookList = new ArrayList<>();
        if (titleFragment.length() < 3) return bookList;
        List<Book> resultList = libraryDatabase.listBooksWithCondition(titleFragment);
        if (resultList.size() > 20) return bookList;
        bookList = resultList;
        return bookList;
    }

    public List<Book> listBooksInHandsOf(LibraryUser libraryUser) {
        List<Book> booksList = new ArrayList<>();
        List<Book> borrowedList = libraryDatabase.listBooksInHandsOf(libraryUser);
        if (borrowedList.size() == 0) return booksList;
        booksList = borrowedList;
        return booksList;
    }
}
