package com.kodilla.patterns.strategy.social;

public sealed class User
    permits Millenials, YGeneration, ZGeneration {

    protected SocialPublisher socialPublisher;

    public String showYourself() {
        return "User: " + socialPublisher.share();
    }

    public void changePreferredSocialMedia(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }
}
