package com.ccreanga.example.java8.annotations;

import java.util.List;

@Manufacturer( "Mercedes Benz")
@Manufacturer( "BMW")
@Manufacturer( "Dacia 1100")
public class Vehicle {

    //type annotations
    @ExampleTypeAnnotation String vehicleId;
    List<@ExampleTypeAnnotation String> components;

    public static void main(String[] args) {

        Cars cars = Vehicle.class.getAnnotation(Cars.class);
        for(Manufacturer car: cars.value()){
            System.out.println(car.value());
        }

    }

}
