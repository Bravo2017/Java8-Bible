package com.ccreanga.example.java8.lambda.syntax;

import com.ccreanga.example.java8.Person;
import com.ccreanga.example.java8.PersonsRepo;

import java.util.function.Predicate;

public class LambdaExamplePredicates {

    //a simple method to print persons
    public static void printPersonsWithPredicate(Person[] persons, Predicate<Person> predicate) {
        for (Person p : persons) {
            if (predicate.test(p)) {
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {
        Person[] persons = PersonsRepo.persons();

        printPersonsWithPredicate(
                persons,
                p -> p.getAge()>=18
        );


    }

}
