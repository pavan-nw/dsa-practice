package com.example.practice.dp;

import java.util.Arrays;

// https://www.youtube.com/watch?v=-lfHWWMmXXM

public class FindLongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] a = {10,22,9,33,21,50,41,60};
        int n = a.length;
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(a[i] > a[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        int max = lis[0];
//        Arrays.stream(lis).forEach(System.out::println);
        for (int i = 1; i < lis.length; i++) {
            if(lis[i] > max) {
                max = lis[i];
            }
        }
        System.out.println("LIS: " + max);
    }
}
