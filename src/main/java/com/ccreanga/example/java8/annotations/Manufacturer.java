package com.ccreanga.example.java8.annotations;


import java.lang.annotation.Repeatable;

@Repeatable(value = Cars.class )
public @interface Manufacturer {
    String value();

};
