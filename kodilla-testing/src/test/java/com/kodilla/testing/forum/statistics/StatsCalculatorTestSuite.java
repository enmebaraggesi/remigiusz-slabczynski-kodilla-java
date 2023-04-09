package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StatsCalculatorTestSuite {

    private List<String> generateNamesList(int quantity) {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            list.add("User " + i);
        }
        return list;
    }

    @Mock
    private Statistics statisticsMock;

    @Test
    void testCalculateAdvStatisticsWith0Posts() {

        //Given
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.postsCount()).thenReturn(0);
        List<String> listOf10 = generateNamesList(10);
        when(statisticsMock.usersNames()).thenReturn(listOf10);
        StatsCalculator statsCalculator = new StatsCalculator();
        statsCalculator.calculateAdvStatistics(statisticsMock);

        //When
        double postsPerUserResult = statsCalculator.getPostsPerUser();
        double commentsPerUserResult = statsCalculator.getCommentsPerUser();
        double commentsPerPostResult = statsCalculator.getCommentsPerPost();

        //Then
        Assertions.assertEquals(0, postsPerUserResult);
        Assertions.assertEquals(0, commentsPerUserResult);
        Assertions.assertEquals(0, commentsPerPostResult);
    }

    @Test
    void testCalculateAdvStatisticsWith1000Posts() {

        //Given
        when(statisticsMock.commentsCount()).thenReturn(1000);
        when(statisticsMock.postsCount()).thenReturn(1000);
        List<String> listOf10 = generateNamesList(10);
        when(statisticsMock.usersNames()).thenReturn(listOf10);
        StatsCalculator statsCalculator = new StatsCalculator();
        statsCalculator.calculateAdvStatistics(statisticsMock);

        //When
        double postsPerUserResult = statsCalculator.getPostsPerUser();
        double commentsPerUserResult = statsCalculator.getCommentsPerUser();
        double commentsPerPostResult = statsCalculator.getCommentsPerPost();

        //Then
        Assertions.assertEquals(100, postsPerUserResult);
        Assertions.assertEquals(100, commentsPerUserResult);
        Assertions.assertEquals(1, commentsPerPostResult);
    }

    @Test
    void testCalculateAdvStatisticsWith0Comments() {

        //Given
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.postsCount()).thenReturn(100);
        List<String> listOf10 = generateNamesList(10);
        when(statisticsMock.usersNames()).thenReturn(listOf10);
        StatsCalculator statsCalculator = new StatsCalculator();
        statsCalculator.calculateAdvStatistics(statisticsMock);

        //When
        double postsPerUserResult = statsCalculator.getPostsPerUser();
        double commentsPerUserResult = statsCalculator.getCommentsPerUser();
        double commentsPerPostResult = statsCalculator.getCommentsPerPost();

        //Then
        Assertions.assertEquals(10, postsPerUserResult);
        Assertions.assertEquals(0, commentsPerUserResult);
        Assertions.assertEquals(0, commentsPerPostResult);
    }

    @Test
    void testCalculateAdvStatisticsWithLessCommentsThanPosts() {

        //Given
        when(statisticsMock.commentsCount()).thenReturn(500);
        when(statisticsMock.postsCount()).thenReturn(1000);
        List<String> listOf10 = generateNamesList(10);
        when(statisticsMock.usersNames()).thenReturn(listOf10);
        StatsCalculator statsCalculator = new StatsCalculator();
        statsCalculator.calculateAdvStatistics(statisticsMock);

        //When
        double postsPerUserResult = statsCalculator.getPostsPerUser();
        double commentsPerUserResult = statsCalculator.getCommentsPerUser();
        double commentsPerPostResult = statsCalculator.getCommentsPerPost();

        //Then
        Assertions.assertEquals(100, postsPerUserResult);
        Assertions.assertEquals(50, commentsPerUserResult);
        Assertions.assertEquals(0.5, commentsPerPostResult);
    }

    @Test
    void testCalculateAdvStatisticsWithMoreCommentsThanPosts() {

        //Given
        when(statisticsMock.commentsCount()).thenReturn(1000);
        when(statisticsMock.postsCount()).thenReturn(500);
        List<String> listOf10 = generateNamesList(10);
        when(statisticsMock.usersNames()).thenReturn(listOf10);
        StatsCalculator statsCalculator = new StatsCalculator();
        statsCalculator.calculateAdvStatistics(statisticsMock);

        //When
        double postsPerUserResult = statsCalculator.getPostsPerUser();
        double commentsPerUserResult = statsCalculator.getCommentsPerUser();
        double commentsPerPostResult = statsCalculator.getCommentsPerPost();

        //Then
        Assertions.assertEquals(50, postsPerUserResult);
        Assertions.assertEquals(100, commentsPerUserResult);
        Assertions.assertEquals(2, commentsPerPostResult);
    }

    @Test
    void testCalculateAdvStatisticsWith0Users() {

        //Given
        when(statisticsMock.commentsCount()).thenReturn(500);
        when(statisticsMock.postsCount()).thenReturn(1000);
        List<String> listOf0 = new ArrayList<>();
        when(statisticsMock.usersNames()).thenReturn(listOf0);
        StatsCalculator statsCalculator = new StatsCalculator();
        statsCalculator.calculateAdvStatistics(statisticsMock);

        //When
        double postsPerUserResult = statsCalculator.getPostsPerUser();
        double commentsPerUserResult = statsCalculator.getCommentsPerUser();
        double commentsPerPostResult = statsCalculator.getCommentsPerPost();

        //Then
        Assertions.assertEquals(0, postsPerUserResult);
        Assertions.assertEquals(0, commentsPerUserResult);
        Assertions.assertEquals(0.5, commentsPerPostResult);
    }

    @Test
    void testCalculateAdvStatisticsWith100Users() {

        //Given
        when(statisticsMock.commentsCount()).thenReturn(2000);
        when(statisticsMock.postsCount()).thenReturn(1000);
        List<String> listOf100 = generateNamesList(100);
        when(statisticsMock.usersNames()).thenReturn(listOf100);
        StatsCalculator statsCalculator = new StatsCalculator();
        statsCalculator.calculateAdvStatistics(statisticsMock);

        //When
        double postsPerUserResult = statsCalculator.getPostsPerUser();
        double commentsPerUserResult = statsCalculator.getCommentsPerUser();
        double commentsPerPostResult = statsCalculator.getCommentsPerPost();

        //Then
        Assertions.assertEquals(10, postsPerUserResult);
        Assertions.assertEquals(20, commentsPerUserResult);
        Assertions.assertEquals(2, commentsPerPostResult);
    }
}