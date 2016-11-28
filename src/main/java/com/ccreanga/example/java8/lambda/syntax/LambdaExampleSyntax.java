package com.ccreanga.example.java8.lambda.syntax;

import com.ccreanga.example.java8.Person;
import com.ccreanga.example.java8.PersonsRepo;

public class LambdaExampleSyntax {

    //a simple,naive method to print all the persons>18
    public static void printPersonsHavingMajorityAge(Person[] persons) {
        for (Person p : persons) {
            if (p.getAge()>=18) {
                System.out.println(p);
            }
        }
    }

    //a more generic method to print all the persons satisfying a condition
    public static void printPersons(Person[] persons, CheckPerson check) {
        for (Person p : persons) {
            if (check.test(p)) {
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {
        Person[] persons = PersonsRepo.persons();

        //conventional way
        CheckPersonMajorityAge checkPersonMajorityAge = new CheckPersonMajorityAge();
        printPersons(persons,checkPersonMajorityAge);
        //conventional way
        printPersons(persons, new CheckPerson() {
            public boolean test(Person p) {
                return p.getAge()>=18;
            }
        });


        //lambda
        printPersons(
                persons,
                (Person p) -> {return p.getAge()>=18;}
        );

        //lambda - condensed
        printPersons(
                persons,
                p -> p.getAge()>=18
        );

    }
}
