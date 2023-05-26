package com.kodilla.good.patterns.challenges.movie_store;

import java.util.*;

public class TitleDisplay {

    public static void main(String[] args) {

        MovieStore movieStore = new MovieStore();
        System.out.println(mergeTitlesStream(movieStore.getMovies()));
    }

    public static String mergeTitlesStream(Map<String, List<String>> titleCollection) {

        return (titleCollection.values().stream()
            .flatMap(List<String>::stream)
            .reduce((string1, string2) -> string1 + "!" + string2))
            .orElse("");
    }
}
