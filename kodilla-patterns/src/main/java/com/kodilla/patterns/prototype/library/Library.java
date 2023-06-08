package com.kodilla.patterns.prototype.library;

import com.kodilla.patterns.prototype.Prototype;

import java.util.*;

public final class Library extends Prototype {

    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public Library shallowCopy(String name) throws CloneNotSupportedException {
        Library clonedLibrary = (Library) super.clone();
        clonedLibrary.setName(name);
        return clonedLibrary;
    }

    public Library deepCopy(String name) throws CloneNotSupportedException {
        Library clonedLibrary = (Library) super.clone();
        Set<Book> clonedSet = new HashSet<>(books);
        clonedLibrary.setName(name);
        clonedLibrary.setBooks(clonedSet);
        return clonedLibrary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
