package com.example;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        Processor processor = new Processor(person);

        processor.runMenu();
    }
}
