package com.ccreanga.example.java8.lambda.syntax;

import com.ccreanga.example.java8.Person;
import com.ccreanga.example.java8.PersonsRepo;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaExampleProdConsumer {

    //a more generic method to process persons
    public static void processPersonsWithPredicate(Person[] persons, Predicate<Person> predicate,Consumer<Person> consumer) {
        for (Person p : persons) {
            if (predicate.test(p)) {
                consumer.accept(p);
            }
        }
    }

    public static void main(String[] args) {
        Person[] persons = PersonsRepo.persons();

        processPersonsWithPredicate(
                persons,
                p -> p.getAge() >= 18,
                p -> System.out.println(p)
        );

    }

}
