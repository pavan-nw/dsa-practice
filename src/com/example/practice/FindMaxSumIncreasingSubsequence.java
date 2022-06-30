package com.example.practice;

// https://www.youtube.com/watch?v=0NPYcQQWJ3Q

public class FindMaxSumIncreasingSubsequence {
    public static void main(String[] args) {
//        int[] a = {1,101,2,3,100,4,5};
        int[] a = {1,-101,2,3,-100,4,5};
//        int[] a = {3,4,5,10};
//        int[] a = {10,5,4,3};
        int n = a.length;
        int[] mis = new int[n];
        for (int i = 0; i < mis.length; i++) {
            mis[i] = a[i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(a[i] > a[j] && mis[i] < mis[j] + a[i]) {
                    mis[i] = mis[j] + a[i];
                }
            }
        }

        int max = mis[0];
//        Arrays.stream(mis).forEach(System.out::println);
        for (int i = 1; i < mis.length; i++) {
            if(mis[i] > max) {
                max = mis[i];
            }
        }
        System.out.println("MIS: " + max);
    }
}
