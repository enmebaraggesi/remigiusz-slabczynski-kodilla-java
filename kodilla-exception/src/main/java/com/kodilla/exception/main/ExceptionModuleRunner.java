package com.kodilla.exception.main;

import com.kodilla.exception.io.*;

public class ExceptionModuleRunner {

    public static void main(String[] args) {

        FileReader fileReader = new FileReader();

        try {
            fileReader.readFile("names.txt");
        } catch (FileReaderException e) {
            System.out.println("Problem while reading a file!");
        }
    }
}