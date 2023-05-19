package com.example.practice.ns;
/**
 * Problem Statement
 * You have received a lot of sweets on diwali and therefore you decided to distibute them to the needy children. There are N needy children numbered from 1 to N and the ith child wants to get at least ci boxes. The children are all standing in a line in ascending order of their numbering. You will distribute the sweets in the following way:
 * <p>
 * Give K boxes of sweets to the child in front of the line. If this child has not received enough boxes yet, you send him to the back of the line, else you send him home.
 * <p>
 * Repeat this step until the line is not empty
 * <p>
 * Find the number of the child who receives the sweets at the very last.
 * Input
 * The first line of the input contains two integers N and K.
 * The second line of the input contains N space seperated integers.
 * <p>
 * Constraints:
 * 1 <= N <= 105
 * 1 <= ci <= 109
 * 1 <= K <= 109
 * Output
 * Print the number of the child who receives the sweets at the very last.
 * Example
 * Sample Input:
 * 5 2
 * 1 3 1 4 2
 * <p>
 * Sample Output:
 * 4
 */

import java.util.Scanner;

// don't change the name of this class
// you can add inner classes if needed

// To do: Not solved
class SweetBox {
    public static void main(String[] args) {
        // Your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 5
        int k = sc.nextInt(); // 2
        int lastChild = -1; // this var hold the i which become zero last
        long[] arr = new long[n]; // 1 3 1 4 2 -> 0 1 0 2 0 -> 0 0 0 0 0 -> 4th position -> i + 1
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        long max = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        System.out.println(max);
        sc.close();
    }
}