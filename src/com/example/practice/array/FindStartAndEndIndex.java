package com.example.practice.array;

/**
 * Given an array of integers nums sorted in non-decreasing order,
 * find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 *
 * Sample Ip and Op
 * nums = [5,7,7,8,8,10], target = 8
 */
public class FindStartAndEndIndex {
    public static void main(String[] args) {
        int[] arr = new int[] {5,5,5,7,7,8,8,8,8,10,11};
        int target = 11;
        int posLeft = findLeft(arr, target);
        int posRight = findRight(arr, target);
        if(posRight >= posLeft) {
            System.out.println("[" + posLeft + " "+ posRight+"]");
        } else {
            System.out.println("[-1 -1]");
        }

    }

    private static int findLeft(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right)/2;
            if(arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return left;
    }

    private static int findRight(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right)/2;
            if(arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return right;
    }
}
