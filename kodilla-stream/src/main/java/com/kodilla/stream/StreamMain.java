package com.kodilla.stream;

import com.kodilla.stream.forumuser.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {

        Forum forum = new Forum();

        Map<Integer, ForumUser> newUserList = forum.getUserList().stream()
            .filter(forumUser -> forumUser.getSex() == 'M')
            .filter(forumUser -> LocalDate.now().getYear()
                - forumUser.getDateOfBirth().getYear() >= 20)
            .filter(forumUser -> forumUser.getPublicisedPostsQuantity() > 0)
            .collect(Collectors.toMap(ForumUser::getUserId, forumUser -> forumUser));

        newUserList.entrySet().stream()
            .forEach(System.out::println);
    }
}
