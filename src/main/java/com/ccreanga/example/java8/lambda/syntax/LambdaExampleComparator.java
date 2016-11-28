package com.ccreanga.example.java8.lambda.syntax;

import com.ccreanga.example.java8.Person;
import com.ccreanga.example.java8.PersonsRepo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExampleComparator {

    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(PersonsRepo.persons());

        //java 7 style
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person x, Person y) {
                return x.getName().compareTo(y.getName());
            }
        });

        //java 7 style - add another condition
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person x, Person y) {
                int compare =  x.getName().compareTo(y.getName());
                return (compare==0)?x.getBirthday().compareTo(y.getBirthday()):compare;
            }
        });


        //lambda
        Collections.sort(persons, (x, y) -> x.getName().compareTo(y.getName()));
        System.out.println(persons);
        System.out.println("-------------------------------------------------------------------");

        //lambda - add more comparison criterias
        Collections.sort(persons, Comparator.
                comparing((Person p) -> p.getName()).
                thenComparing((Person p) -> p.getBirthday()));
        System.out.println(persons);


    }

}
