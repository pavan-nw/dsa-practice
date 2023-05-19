package com.example.practice.ns;

import java.util.Scanner;

// don't change the name of this class
// you can add inner classes if needed

/**
 * Problem Statement
 * You are given an integer array A of size N. Find a value of x that minimizes the sum
 * |a1 − x| + |a2 − x| + ··· + |an − x|.
 * If there are multiple answers, print any of them.
 * Input
 * First line contains an integer N - the size of array
 * Next line contains N space separated integers denoting the array A.
 * <p>
 * Constraints
 * 1 <= N <= 100000
 * 1 <= Ai <= 100000
 * Output
 * Print the value of x.
 * Example
 * Sample Input 1:
 * 3
 * 1 2 1
 * <p>
 * Output:
 * 1
 * <p>
 * Explanation:
 * Take x=0. Then the sum is |1-0| + |1-0| + |2-0| = 4
 * Take x=1. Then the sum is |1-1| + |1-1| + |2-1| = 1
 * Take x=2. Then the sum is |1-2| + |1-2| + |2-2| = 2
 * We will find that the minimum value is 1 at x=1.
 * <p>
 * Sample Input 2:
 * 2
 * 1 0
 * <p>
 * Output:
 * 0
 * <p>
 * Explanation:
 * At x=0 we get the sum as 1 which is minimum possible sum.
 */
class MinimizingSum {
    public static void main(String[] args) {
        // Your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        long x = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
            x = Math.max(x, arr[i]);
        }
        long sum = 0;
        long curr = Integer.MAX_VALUE;
        long output = 0;
        System.out.println("Max: " + x);
        while (x >= 0) {
            sum = 0;
            for (int i = 0; i < n; i++) {
                sum = sum + Math.abs(arr[i] - x);
                if (sum > curr) {
                    break;
                }
            }
            if (sum == curr) {
                System.out.println(x + "-->" + sum + "  ");
            }
            if (sum < curr) {
                curr = sum;
                output = x;
            } else if (sum == curr) {
                output = x;
                break;
            }
            x--;
        }
        System.out.println(output);

    }
}