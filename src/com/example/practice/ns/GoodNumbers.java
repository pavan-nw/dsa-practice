package com.example.practice.ns;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem Statement
 * We define a number A as a good integer if:
 * the number of divisors (excluding 1 and the number itself) of A is greater
 * than 0 and the divisors would be in consecutive sequence when arranged in
 * sorted order
 * Given a number N, calculate the number of good integers less than or equal to
 * N.
 * Input
 * The input contains a single integer N.
 * <p>
 * Constraints:
 * 1 <= N <= 109
 * Output
 * Print the number of good integers less than or equal to N.
 * <p>
 * Example
 * Sample Input:-
 * 4
 * <p>
 * Sample Output:-
 * 1
 * <p>
 * Sample Input:-
 * 9
 * <p>
 * Sample Output:-
 * 3
 * <p>
 * Explanation:- 4 6 9 are the only good integers
 */
class GoodNumbers {
    public static void main(String[] args) {
        int N = 10;
        List<Integer> divisiors = new ArrayList<>();
        List<Integer> goodNumbers = new ArrayList<>();
        for (int j = 2; j <= N; j++) {
            divisiors = new ArrayList<>();
            System.out.println("\n---Divisors of " + j + "-----");
            for (int i = 2; i < j; i++) {
                if (j % i == 0) {
                    System.out.print(i + " ");
                    divisiors.add(i);
                }
            }
            if (checkConsec(divisiors)) {
                // System.out.println("Good number is " + j);
                goodNumbers.add(j);
            }
        }
        System.out.println("\nNo of good numbers => " + goodNumbers.size());

    }

    static boolean checkConsec(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) + 1 != list.get(i + 1)) {
                return false;
            }
        }
        return !list.isEmpty();
    }
}