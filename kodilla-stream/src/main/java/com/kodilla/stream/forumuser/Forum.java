package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.*;

public final class Forum {

    private final List<ForumUser> forumUsers = new ArrayList<>();

    public Forum() {

        forumUsers.add(new ForumUser(1, "Aleks Aleksowicz", 'M',
            LocalDate.of(1987, 12, 3), 20));
        forumUsers.add(new ForumUser(2, "Bartosz Bartnik", 'M',
            LocalDate.of(1995, 10, 12), 14));
        forumUsers.add(new ForumUser(3, "Cecylia Cecyl", 'W',
            LocalDate.of(2012, 1, 2), 190));
        forumUsers.add(new ForumUser(4, "Daniel Danielewicz", 'M',
            LocalDate.of(2007, 9, 1), 117));
        forumUsers.add(new ForumUser(5, "Emilia Erm", 'W',
            LocalDate.of(1997, 7, 7), 100));
        forumUsers.add(new ForumUser(6, "Felicja Feliks", 'W',
            LocalDate.of(2003, 3, 30), 97));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(forumUsers);
    }
}
