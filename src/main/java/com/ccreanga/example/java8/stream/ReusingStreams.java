package com.ccreanga.example.java8.stream;

import com.ccreanga.example.java8.Person;
import com.ccreanga.example.java8.PersonsRepo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ReusingStreams {

    public static void main(String[] args) {


        Person[] persons = PersonsRepo.persons();

        Stream<Person> nameStream = Arrays.stream(persons);
        nameStream.forEach(System.out::println);

        //cannot reuse a stream
        try {
            nameStream.forEach(System.out::println);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
