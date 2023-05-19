package com.example.practice.ns;

import java.util.Scanner;

/**
 * Rotated Binary Search
 */
public class RotatedBinarySearch {
    private static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[start] <= nums[mid]) { // left array is sorted -> 4 5 6 7 8 9 10 1 2 3 -> arr[mid] = 9
                // target is between 4 & 9
                if (target >= nums[start] && target < nums[mid]) { // target lies between start and mid index
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
                System.out.println("start: " + start);
                System.out.println("end: " + end);
                System.out.println("----------------");
            } else { // right array is sorted   -> 8 9 10 1 2 3 4 5 6 7
                if (target > nums[mid] && target <= nums[end]) { // target lies between mid and end index
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
                System.out.println("start: " + start);
                System.out.println("end: " + end);
                System.out.println("----------------");
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = keyboard.nextInt();
        }
        int target = keyboard.nextInt();
        keyboard.close();
        System.out.printf("Search(%d) = %d%n", target, search(nums, target));
    }
}
