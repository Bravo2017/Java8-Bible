package com.ccreanga.example.java8.reflection;

import com.ccreanga.example.java8.Person;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectionExample {

    //it only works when using javac with -parameters
    public static void main(String[] args) {
        Class<Person> clazz = Person.class;
        for (Method m : clazz.getDeclaredMethods()) {
            System.out.println(m.getName());
            for (Parameter p : m.getParameters()) {
                System.out.println("  " + p.getName());
            }
        }
    }

}
