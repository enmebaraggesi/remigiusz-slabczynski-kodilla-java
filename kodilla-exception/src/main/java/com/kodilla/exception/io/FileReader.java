package com.kodilla.exception.io;

import java.io.*;
import java.nio.file.*;
import java.util.stream.Stream;

public class FileReader {

    public void readFile() throws FileReaderException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("names.txt").getFile());
        String path = file.getPath();
        path = path.replace("\\", "/");
        path = path.replace("%20", " ");

        try (Stream<String> fileLines = Files.lines(Path.of(path))) {
            fileLines.forEach(System.out::println);
        } catch (IOException e) {
            throw new FileReaderException();
        } finally {
            System.out.println("I am gonna be here... always!");
        }
    }

    public void readFile(final String fileName) throws FileReaderException {

        ClassLoader classLoader = getClass().getClassLoader();

        try (Stream<String> fileLines = Files.lines(Path.of(classLoader.getResource(fileName).toURI()))) {
            fileLines.forEach(System.out::println);
        } catch (Exception e) {
            throw new FileReaderException();
        } finally {
            System.out.println("I am gonna be here... always!");
        }
    }
}