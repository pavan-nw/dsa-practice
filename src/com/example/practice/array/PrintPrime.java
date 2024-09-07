package com.example.practice.array;

import java.util.stream.IntStream;

public class PrintPrime {

    public static void main(String[] args) {
        String result = checkPrime(13) ? "Prime" : "Not a prime";
        System.out.println(result);
    }

    /**
     * Check given number is prime or not
     * - Without using if-else and just in 1 statement
     * @param number
     * @return
     */
    private static boolean checkPrime(Integer number) {
        return IntStream
                .rangeClosed(2, number / 2)
                .noneMatch(value -> number % value == 0);
    }
}
