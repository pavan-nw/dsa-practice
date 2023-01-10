package com.example.practice.c2fo;

import java.util.Arrays;

/**
 * Given an array of integers A, find and return the peak element in it.
 *
 * An array element is peak if it is NOT smaller than its neighbors.
 *
 * For corner elements, we need to consider only one neighbor.
 *
 * For example, for input array {5, 10, 20, 15}, 20 is the only peak element.
 *
 * Following corner cases give better idea about the problem.
 *
 * 1) If input array is sorted in strictly increasing order, the last element is always a peak element.
 * For example, 5 is peak element in {1, 2, 3, 4, 5}.
 * 2) If input array is sorted in strictly decreasing order, the first element is always a peak element.
 * 10 is the peak element in {10, 9, 8, 7, 6}.
 * Note: It is guranteed that the answer is unique.
 *
 * Input 1:
 *     A = [1, 2, 3, 4, 5]
 * Output 1:
 *     5
 *
 * Input 2:
 *     A = [5, 17, 100, 11, 6,8,9,7]
 * Output 2:
 *     100
 */

// https://www.interviewbit.com/problems/find-a-peak-element/
public class Round1 {
    public static void main(String[] args) {
        findPeak();
        findPeakUsingBinarySearch();
        printPermutations();
    }

    private static void findPeak() {
        int[] arr = {5, 10, 20, 15};
//        int[] arr = {5, 17, 100, 11};
//        int[] arr = {1, 2, 3, 4, 5};
        int peak = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(i == 0 && arr[i] > arr[i+1]) {
                if(peak < arr[0])
                    peak = arr[0];
            } else if(i == arr.length-1 && arr[i] > arr[i-1]) {
                if(peak < arr[arr.length -1])
                    peak = arr[arr.length -1];
            } else if(i!=0 && arr[i-1]<arr[i] && arr[i]>arr[i+1]) {
                if(peak < arr[i])
                    peak = arr[i];
            }
        }
        System.out.println("Peak: " + peak);
    }

    private static void findPeakUsingBinarySearch() {
        int[] arr = {5, 10, 20, 15};
//        int[] arr = {5, 17, 100, 11};
//        int[] arr = {1, 2, 3, 4, 5};
        int low  = 0;
        int high = arr.length - 1;
        System.out.println("Peak: " + find(arr, low, high));
    }

    private static int find(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        if((mid== 0 || arr[mid] >= arr[mid-1]) && (mid == arr.length-1 || arr[mid+1] <= arr[mid])) {
            return arr[mid];
        } else if(mid-1 > 0 && arr[mid-1] >  arr[mid]) {
            return find(arr, low, mid-1);
        } else {
            return find(arr, mid+1, high);
        }
    }

    /**
     * Given a collection of numbers, return all possible permutations.
     *
     * [1,2,3] will have the following permutations:
     *
     * [1,2,3]
     * [1,3,2]
     * [2,1,3]
     * [2,3,1]
     * [3,1,2]
     * [3,2,1]
     */

    static void printPermutations() {
        int[] arr = {1,2,3,4};
        doPermutations(arr, 0, arr.length-1);
    }

    static void doPermutations(int[] arr, int l, int r) {
        if(l == r) {
            Arrays.stream(arr).forEach(x -> {
                System.out.print(x+" ");
            });
            System.out.println("");
            return;
        }
        for (int i = l; i <= r; i++) {
            swap(arr, l, i);
            doPermutations(arr, l+1, r);
            swap(arr, l, i);
        }
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}


/*
There are two tribes in Mars, Lie tribe and Truth Tribe.

Lie tribe always speaks lie, True tribe always speaks truth.

You meet three mars people and ask from the first Person:

Q: What tribe do you belong to?
He replies something in his language which you don’t understand.

Second person tells you that he is saying that he belongs to Lie Tribe.

Third person says that second person is lying.

What tribe does the third person belong to?
 */
