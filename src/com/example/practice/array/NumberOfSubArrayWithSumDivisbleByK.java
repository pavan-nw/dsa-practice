package com.example.practice.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 Given a large list of positive integers, count the number of k-subsequences.
 A k-subarray of an array is defined as follows:

 It is a subarray, i.e. made of contiguous elements in the array
 The sum of the subarray elements, s, is evenly divisible by _k, _i.e.: sum mod k = 0.

 Given an array of integers, determine the number of k-subarrays it contains.
 For example, k = 5 and the array nums = [5, 10, 11, 9, 5].  The  10 k-subarrays are: {5}, {5, 10}, {5, 10, 11, 9}, {5, 10, 11, 9, 5}, {10}, {10, 11, 9}, {10, 11, 9, 5}, {11, 9}, {11, 9, 5}, {5}.

 **Function Description **
 Complete the function kSub in the editor below.
 The function must return a long integer that represents the number of k-subarrays in the array.
 kSub has the following parameter(s):

 k:  the integer divisor of a k-subarray
 nums[nums[0],...nums[n-1]]:  an array of integers

 Constraints
 1 ≤ n ≤ 3 × 105
 1 ≤ k ≤ 100
 1 ≤ nums[i] ≤ 104
 */

// https://www.youtube.com/watch?v=QM0klnvTQzk

public class NumberOfSubArrayWithSumDivisbleByK {
    public static void main(String[] args) {
        System.out.println(kSub(Arrays.asList(5, 10, 11, 9, 5), 5));
    }

    public static long kSub(List<Integer> nums, int k) {
        long count = 0;
        int sum = 0;
        int rem = 0;

        HashMap<Integer, Integer> rmap = new HashMap<>();
        rmap.put(rem, 1);

        for (Integer integer : nums) {
            sum = sum + integer;
            rem = sum % k;
            if(rem < 0) rem = rem + k;
            if(rmap.containsKey(rem)) {
                count = count + rmap.get(rem);
                rmap.put(rem, rmap.get(rem) + 1);
            } else {
                rmap.put(rem, 1);
            }
        }

        return count;
    }
}
