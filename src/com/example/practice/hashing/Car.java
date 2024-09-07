package com.example.practice.hashing;

public class Car {

    private String brand;
    private String name;
    private int year;

    public Car(String brand, String name, int year) {
        this.brand = brand;
        this.name = name;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int hashCode() {
        int hashcode = this.name.hashCode() + this.brand.hashCode() + year;
        System.out.println("hashcode: " + hashcode);
        return hashcode;
    }

    // if 2 cars equal and then hashcode should also be equal and vice versa may not be same

    @Override
    public boolean equals(Object obj) {
        Car car1 = (Car)obj;
        return name.equals(car1.name) && brand.equals(car1.brand) & year == car1.year;
//        return hashCode() == obj.hashCode();
    }
}
