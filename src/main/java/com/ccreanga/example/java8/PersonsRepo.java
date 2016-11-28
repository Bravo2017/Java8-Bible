package com.ccreanga.example.java8;

import java.time.LocalDate;
import java.util.Arrays;

public class PersonsRepo {

    public static Person[] persons(){
        return new Person[]{
                new Person("nero",LocalDate.of(1956,1,1), Person.Gender.MALE,
                        Arrays.asList(new Address("Roma","street 1"), new Address("Napoli","street 12"))),
                new Person("traian",LocalDate.of(1955,1,1), Person.Gender.MALE,
                        Arrays.asList(new Address("Delphi","street 1"))),
                new Person("agripina",LocalDate.of(1990,1,1), Person.Gender.FEMALE,
                        Arrays.asList(new Address("Roma","street 1"),new Address("Athena","street 1"),new Address("Delphi","street 2"))),
                new Person("agripina",LocalDate.of(1977,1,1), Person.Gender.FEMALE,
                        Arrays.asList(new Address("Roma","street 3"))),
                new Person("hadrian",LocalDate.of(1959,1,1), Person.Gender.MALE,
                        Arrays.asList(new Address("Roma","street 3"))),
                new Person("brutus",LocalDate.of(2000,1,1), Person.Gender.MALE,
                        Arrays.asList(new Address("Pompei","street1"))),
        };

    }
}
