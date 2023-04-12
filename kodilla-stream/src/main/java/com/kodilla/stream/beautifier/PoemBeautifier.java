package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public String beautify(String normalText, PoemDecorator poemDecorator) {
        return poemDecorator.decorate(normalText);
    }
}
