package com.ccreanga.example.java8.lambda.methodref;

import com.ccreanga.example.java8.Person;
import com.ccreanga.example.java8.PersonsRepo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaExampleMethodRef {


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

        //Lambda expressions
        Comparator<Person> ageComparatorNew = (a, b) -> a.getBirthday().compareTo(b.getBirthday());


        //lambda expression
        Arrays.sort(persons,
                Comparator.comparing(p->p.getAge())
        );

        //OR lambda expression + method reference
        Arrays.sort(persons,
                Comparator.comparing(Person::getAge)
        );

        //the static methods can also be referenced
        processPersonsWithPredicate(
                persons,
                p -> p.getAge() >= 18,
                p -> System.out.println(p)
        );
        processPersonsWithPredicate(
                persons,
                p -> p.getAge() >= 18,
                System.out::println
        );



        //it can also be a reference to a constructor

        Supplier supplier = () -> { return new HashSet<>();};
        //replaced with
        supplier = HashSet::new;




    }

}
