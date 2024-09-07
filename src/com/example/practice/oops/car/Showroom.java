package com.example.practice.oops.car;

import java.util.ArrayList;
import java.util.List;

public class Showroom {
    private String name;
    private String city;
    private String location;

    public Showroom(String name, String city, String location) {
        this.name = name;
        this.city = city;
        this.location = location;
    }

    private List<Car> cars = new ArrayList<>();

    public void displayShowroomDetails() {
        System.out.println("Name: " + name);
        System.out.println("City: " + city);
        System.out.println("Loc: " + location);
        for(Car c : cars) {
            c.displayCarDetails();
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
