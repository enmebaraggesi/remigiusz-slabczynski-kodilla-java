package com.kodilla.patterns.strategy.social;

public final class YGeneration extends User {

    public YGeneration() {
        this.socialPublisher = new TwitterPublisher();
    }
}
