package com.kodilla.patterns.builder.bigmac;

public enum Sauce {

    STANDARD("standard"),
    THOUSAND_ISLAND("1000 island"),
    BBQ("barbecue");

    private final String sauce;

    Sauce(String sauce) {
        this.sauce = sauce;
    }

    public String getSauce() {
        return sauce;
    }
}
