package com.kodilla.testing.forum.statistics;

public class StatsCalculator {

    private int numOfUsers;
    private int numOfPosts;
    private int numOfComments;
    private double postsPerUser;
    private double commentsPerUser;
    private double commentsPerPost;

    public void calculateAdvStatistics(Statistics statistics) {

        numOfPosts = statistics.postsCount();
        numOfComments = statistics.commentsCount();
        numOfUsers = statistics.usersNames().size();
        if (numOfUsers != 0) {
            postsPerUser = (double) numOfPosts / numOfUsers;
        } else {
            postsPerUser = 0.0;
        }
        if (numOfUsers != 0) {
            commentsPerUser = (double) numOfComments / numOfUsers;
        } else {
            commentsPerUser = 0.0;
        }
        if (numOfPosts != 0) {
            commentsPerPost = (double) numOfComments / numOfPosts;
        } else {
            commentsPerUser = 0.0;
        }

    }

    public void showStatistics() {

        System.out.printf("Total number of users: " + numOfUsers + "\n"
                + "Total number of posts: " + numOfPosts + "\n"
                + "Total number of comments: " + numOfComments + "\n"
                + "Posts per user: " + postsPerUser + ", "
                + "comments per user: " + commentsPerUser + ", "
                + "comments per post: " + commentsPerPost);
    }

    public double getPostsPerUser() {
        return postsPerUser;
    }

    public double getCommentsPerUser() {
        return commentsPerUser;
    }

    public double getCommentsPerPost() {
        return commentsPerPost;
    }
}
