package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {

        //Given
        User millennialUser = new Millenials();
        User yGenUser = new YGeneration();
        User zGenUser = new ZGeneration();

        //When
        String millennialResult = millennialUser.showYourself();
        String yGenResult = yGenUser.showYourself();
        String zGenResult = zGenUser.showYourself();

        //Then
        assertEquals("User: [posts] on Facebook", millennialResult);
        assertEquals("User: [tweets] on Twitter", yGenResult);
        assertEquals("User: [snaps] on Snapchat", zGenResult);
    }

    @Test
    void testIndividualSharingStrategy() {

        //Given
        User fancyMillennialUser = new Millenials();

        //When
        String defaultSharing = fancyMillennialUser.showYourself();
        fancyMillennialUser.changePreferredSocialMedia(new SnapchatPublisher());
        String updatedSharing = fancyMillennialUser.showYourself();

        //Then
        assertEquals("User: [posts] on Facebook", defaultSharing);
        assertEquals("User: [snaps] on Snapchat", updatedSharing);
    }
}