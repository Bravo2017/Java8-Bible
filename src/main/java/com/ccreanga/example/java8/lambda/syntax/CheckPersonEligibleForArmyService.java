package com.ccreanga.example.java8.lambda.syntax;

import com.ccreanga.example.java8.Person;

public class CheckPersonEligibleForArmyService implements CheckPerson {
    public boolean test(Person p) {
        return p.getAge() >= 18 && p.getAge() <= 50 && p.isMale();
    }
}