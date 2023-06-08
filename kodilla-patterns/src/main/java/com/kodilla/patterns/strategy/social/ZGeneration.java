package com.kodilla.patterns.strategy.social;

public final class ZGeneration extends User {

    public ZGeneration() {
        this.socialPublisher = new SnapchatPublisher();
    }
}
