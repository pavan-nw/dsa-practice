package com.example.practice.oops.shape;

public class Demo {
    public static void main(String[] args) {
        Circle circle1 = new Circle(5);
        Circle circle2 = new Circle(10);
        circle1.computeArea();
        circle2.computeArea();
        System.out.println("Area of circle1: " + circle1.getArea());
        System.out.println("Area of circle2: " + circle2.getArea());
        System.out.println("Diameter of circle1: " + circle2.getDiameter());
        System.out.println("PI: " + circle1.PI);
        System.out.println("PI: " + circle2.PI);
        System.out.println("PI: " + Circle.PI);
//        circle1.area = 3.142 * circle1.radius * circle1.radius;
//        System.out.println("Area: " + circle1.area);
//        circle1.radius = 10;
//        circle1.area = 3.142 * circle1.radius * circle1.radius;
//        System.out.println("Area: " + circle1.area);
    }
}
