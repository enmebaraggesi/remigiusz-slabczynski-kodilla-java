package com.kodilla.exception.io;

import java.io.*;
import java.nio.file.*;
import java.util.stream.Stream;

public class FileReaderWithoutHandling {

    public void readFile() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("names.txt").getFile());
        Stream<String> fileLines = Files.lines(Paths.get(file.getPath()));
        fileLines.forEach(System.out::println);
    }
}
