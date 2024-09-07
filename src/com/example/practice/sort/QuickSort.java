package com.example.practice.sort;

import java.util.Arrays;
import java.util.Stack;

public class QuickSort {
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(arr, low, high);
            System.out.println("Pivot : "+ arr[pivotIndex] +", After partition: " + Arrays.toString(arr));

            // Recursively apply QuickSort to the left and right sub-arrays
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        // Select the pivot element (last element)
        int pivot = arr[high];
        System.out.println("Pivot selected: " + pivot);

        // Initialize the partition index
        int i = low - 1;

        // Iterate through the array
        for (int j = low; j < high; j++) {
            // If the current element is smaller than the pivot, swap arr[i+1] and arr[j]
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Place the pivot element in its correct position
        swap(arr, i + 1, high);

        // Return the pivot index
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + ", " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSortIterative(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int low = 0;
        int high = arr.length - 1;

        stack.push(low);
        stack.push(high);

        while (!stack.isEmpty()) {
            high = stack.pop();
            low = stack.pop();

            int pivotIndex = partition(arr, low, high);
            System.out.println("Pivot : "+ arr[pivotIndex] +", After partition: " + Arrays.toString(arr));

            if (pivotIndex - 1 > low) {
                stack.push(low);
                stack.push(pivotIndex - 1);
            }

            if (pivotIndex + 1 < high) {
                stack.push(pivotIndex + 1);
                stack.push(high);
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {8, 4, 2, 9, 5, 1};

        System.out.println("Before sorting: " + Arrays.toString(arr));

        quickSort(arr);
//        quickSortIterative(arr);

        System.out.println("After sorting: " + Arrays.toString(arr));
    }
}

