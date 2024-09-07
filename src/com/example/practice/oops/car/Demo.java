package com.example.practice.oops.car;

public class Demo {
    public static void main(String[] args) {
        Showroom showroom = new Showroom("Newton", "Bangalore", "MG Road");

        Car car1 = new Car("Tata", "Punch", 9);
        Car car2 = new Car("Tata", "Nexon", 12);

        showroom.getCars().add(car1);
        showroom.getCars().add(car2);

//        car1.displayCarDetails();
        showroom.displayShowroomDetails();


    }
}
