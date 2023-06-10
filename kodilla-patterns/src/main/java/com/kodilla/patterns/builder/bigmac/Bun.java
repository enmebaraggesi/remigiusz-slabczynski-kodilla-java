package com.kodilla.patterns.builder.bigmac;

public enum Bun {

    SESAME("sesame"),
    PLAIN("plain");

    private final String bun;

    Bun(String bun) {
        this.bun = bun;
    }

    public String getBun() {
        return bun;
    }
}
