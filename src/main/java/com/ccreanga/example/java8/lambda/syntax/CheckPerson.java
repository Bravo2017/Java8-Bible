package com.ccreanga.example.java8.lambda.syntax;

import com.ccreanga.example.java8.Person;

//optional
@FunctionalInterface
public interface CheckPerson {
    boolean test(Person p);
}
