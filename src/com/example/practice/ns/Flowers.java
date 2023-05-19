package com.example.practice.ns;
/**
 * Problem Statement
 * The flower shop near his house sells flowers of N types. It is found that the store has Ai flowers of the i-th type. We like odd numbers. Therefore, we have decided that there should be an odd number of flowers of each type in the bouquet, and the total number of flowers in the bouquet should also be odd.
 * Determine the maximum number of flowers the bouquet can consist of.
 * Input
 * The first line contains an integer N — the number of types of flowers that are sold in the store
 * The second line contains N integers— the number of flowers of each type
 * <p>
 * 1 <= N <= 100000
 * 1 <= Ai <= 1000
 * Output
 * Print one number — the maximum number of flowers the bouquet can consist of.
 * Example
 * Sample input
 * 3
 * 3 5 8
 * <p>
 * Sample output
 * 15
 * <p>
 * Sample input
 * 3
 * 1 1 1
 * <p>
 * Sample output
 * 3
 **/

import java.util.Scanner;

// don't change the name of this class
// you can add inner classes if needed
class Flowers {
    public static void main(String[] args) {
        // Your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] count = new int[n]; // store the numbers which added to sum
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();

            if (arr[i] % 2 == 1) {
                sum = sum + arr[i];
                count[i] = arr[i];
            } else {
                sum = sum + (arr[i] - 1);
                count[i] = arr[i] - 1;
            }
        }
        // System.out.println("Flowers taken for sum are.. ");
        // Arrays.stream(count).forEach(c -> System.out.print(c + " "));
        // count array will have all the numbers which are added to sum -> 13 15 19 13
        // ==> 60 (even) - 13 (min odd) => 47 (max odd)
        // 10 13 14 18 12 16 -> 9 13 13 17 11 15 -> 78 - 9 = 69
        if (sum % 2 == 0) {
            int minIndex = min(count);
            // System.out.println("min odd found: " + count[minIndex]);
            sum = sum - count[minIndex];
        }

        System.out.println("\n" + sum);
    }

    static int min(int[] arr) {
        int minIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }
}