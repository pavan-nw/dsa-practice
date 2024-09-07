package com.example.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Pavan");
        list.add("Dheeraj");
        list.add("Mahesh");
        list.add("Ram");

        List<String> result = list
                .parallelStream()
                .filter( item -> item.length() > 5)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        result.forEach(System.out::println);
    }
}
