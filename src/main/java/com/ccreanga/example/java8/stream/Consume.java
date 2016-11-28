package com.ccreanga.example.java8.stream;

import com.ccreanga.example.java8.Person;
import com.ccreanga.example.java8.PersonsRepo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Consume {

    public static void main(String[] args) {
        Person[] persons = PersonsRepo.persons();

        //COLLECT  -  an aggregation operation where a "collection" is created and each element is "added" to that collection
        //Built in Collectors for most of the cases
        List<Person> filtered = Arrays.stream(persons).filter(p -> p.getAge() >= 18).collect(Collectors.toList());
        System.out.println(filtered);

    }
}
