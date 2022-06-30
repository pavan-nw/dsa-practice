package com.example.practice;

// https://www.youtube.com/watch?v=-lfHWWMmXXM

public class FindMinPositiveNumber {
    public static void main(String[] args) {
        int[] a = {2,4,1,-3,-1,7};
//        int[] a = {2,4,1,5,3,7};
//        int[] a = {3,2,-4,1,-3,6,-1,7,4};
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int correctPos = a[i]-1;
            while (a[i]>0 && a[i] < n && a[correctPos] != a[i]) {
                int temp = a[correctPos];
                a[correctPos] = a[i];
                a[i] = temp;
                correctPos = a[i]-1;
            }
        }
//        Arrays.stream(a).forEach(System.out::println);
        for (int i = 0; i < n; i++) {
            if(a[i] != i+1) {
                System.out.println("First missing +ve number: " + ++i);
                break;
            }
        }
    }
}
