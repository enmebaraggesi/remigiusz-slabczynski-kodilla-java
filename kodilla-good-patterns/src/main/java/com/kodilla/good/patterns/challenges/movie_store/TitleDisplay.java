package com.kodilla.good.patterns.challenges.movie_store;

import java.util.List;
import java.util.Map;

public class TitleDisplay {

    public static void main(String[] args) {

        MovieStore movieStore = new MovieStore();
        System.out.println(mergeTitlesStream(movieStore.getMovies()));
    }

    public static String mergeTitlesStream(Map<String, List<String>> titleCollection) {

        StringBuilder stringBuilder = new StringBuilder();
        titleCollection.values().stream()
                .flatMap(List<String>::stream)
                .forEach(title -> stringBuilder.append(title).append("!"));
        return stringBuilder.toString();
    }
}
