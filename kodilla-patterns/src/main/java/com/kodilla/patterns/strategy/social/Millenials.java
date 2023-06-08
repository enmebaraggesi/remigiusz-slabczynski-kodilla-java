package com.kodilla.patterns.strategy.social;

public final class Millenials extends User {

    public Millenials() {
        this.socialPublisher = new FacebookPublisher();
    }
}
