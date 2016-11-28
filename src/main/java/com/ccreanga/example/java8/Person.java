package com.ccreanga.example.java8;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {

    public enum Gender {
        MALE, FEMALE
    }

    private List<Address> addresses;
    private String name;
    private LocalDate birthday;
    private Gender gender;

    public Person(String name, LocalDate birthday, Gender gender,List<Address> addresses) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.addresses = new ArrayList<>(addresses);
    }

    public int getAge() {
        return  Period.between(birthday, LocalDate.now()).getYears();
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getName() {
        return name;
    }

    public boolean isMale() {
        return gender.equals(Gender.MALE);
    }

    public boolean isFemale() {
        return gender.equals(Gender.FEMALE);
    }

    public List<Address> getAddresses() {
        return Collections.unmodifiableList(addresses);
    }

    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }

    @Override
    public String toString() {
        return "Person{name='" + name + '\'' + ", age=" + getAge() + ", gender=" + gender + '}';
    }
}