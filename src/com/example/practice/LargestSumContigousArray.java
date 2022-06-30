package com.example.practice;

public class LargestSumContigousArray {
    public static void main(String[] args) {
        findMaxSumIterative();
//        findMaxSumDp();
    }

    private static void findMaxSumDp() {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        int current_max_sum = a[0];
        int max_sum = a[0];
        for (int i = 1; i < a.length; i++) {
            current_max_sum = Math.max(a[i], current_max_sum+a[i]);
            max_sum = Math.max(max_sum, current_max_sum);
        }
        System.out.println("Max sum: " + max_sum);
    }

    private static void findMaxSumIterative() {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        int current_max_sum = a[0];
        int max_sum = a[0];
        int start=0, end=0, s=0;
        for (int i = 1; i < a.length; i++) {
            current_max_sum = current_max_sum + a[i];
            if(current_max_sum < 0) {
                current_max_sum = 0;
                s= i+1;

            }
            if (current_max_sum > max_sum) {
                max_sum = current_max_sum;
                start = s;
                end = i;
            }
        }
        System.out.println("Max sum: " + max_sum);
        for (int i = start; i <= end; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
