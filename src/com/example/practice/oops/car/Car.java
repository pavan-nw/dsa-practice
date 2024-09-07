package com.example.practice.oops.car;

public class Car {
    private String brand;
    private String model;
    private int price;

    public Car(String brand, String model, int price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public void displayCarDetails() {
        System.out.println("Car brand: " + this.brand);
        System.out.println("Car model: " + this.model);
        System.out.println("Car price: " + this.price);
    }
}
