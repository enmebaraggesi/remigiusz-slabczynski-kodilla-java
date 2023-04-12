package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {

    private int userId;
    private String name;
    private char sex; // M/F
    private LocalDate dateOfBirth;
    private int publicisedPostsQuantity;

    public ForumUser(int userId, String name, char sex, LocalDate dateOfBirth, int publicisedPostsQuantity) {
        this.userId = userId;
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.publicisedPostsQuantity = publicisedPostsQuantity;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
            "userId=" + userId +
            ", name='" + name + '\'' +
            ", sex=" + sex +
            ", dateOfBirth=" + dateOfBirth +
            ", publicisedPostsQuantity=" + publicisedPostsQuantity +
            '}';
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getPublicisedPostsQuantity() {
        return publicisedPostsQuantity;
    }
}
