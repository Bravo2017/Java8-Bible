package com.ccreanga.example.java8.stream;

import com.ccreanga.example.java8.Person;
import com.ccreanga.example.java8.PersonsRepo;

import java.util.Arrays;

public class Reduce {


    public static void main(String[] args) {
        Person[] persons = PersonsRepo.persons();

        //compute mean age age
        System.out.println("-------------------------------------------------------------------");
        Double averageAge = Arrays.stream(persons)
                .mapToInt(Person::getAge)
                .average()
                .getAsDouble();
        System.out.println(averageAge);

        //OR use REDUCE
        //it applies a binary operator to each element in the stream where
        //the first argument to the operator is the return value of the previous application
        //and the second argument is the current stream element.
        System.out.println("-------------------------------------------------------------------");
        averageAge =  Arrays.stream(persons)
                        .mapToDouble(Person::getAge)
                        .reduce( 0,
                                (acc,age)->acc+age
                        )/persons.length;
        System.out.println(averageAge);

        //compute geometric age
        System.out.println("-------------------------------------------------------------------");
        Double harmonicMeanAge = persons.length/
                Arrays.stream(persons)
                .mapToDouble(Person::getAge)
                .reduce( 0,
                        (acc,age)->acc+1/age
                );
        System.out.println(harmonicMeanAge);



    }
}
