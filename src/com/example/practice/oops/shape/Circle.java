package com.example.practice.oops.shape;

/**
 * Encapsulation: Data hiding (properties are private and only getters and setters are used for accessing the props)
 * Abstraction: Implementation Hiding (Method hiding)
 * Static : Class level
 */
public class Circle {

    private double radius;
    private double area;
    private double perimeter;

    private double diameter;

    public static final double PI = 3.142;

    public Circle(double radius) {
        this.radius = radius;
        computeDiameter();
    }

    public void computeArea() {
        this.area = 3.142 * radius * radius;
    }

    public void computePerimeter() {
        this.area = 2 * 3.142 * radius;
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    private void computeDiameter() {
        this.diameter = 2 * radius;
    }

    public double getDiameter() {
        return diameter;
    }
}
