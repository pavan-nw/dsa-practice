package com.example.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of _n _integers, and a required sum _k, _find the number of subarrays whose sum is equal to the required sum. A subarray is a contiguous segment of an array.
 * Example
 * arr = [1, 2, 3, 0]
 * k = 3
 *
 * There are 3 subarrays whose sum is equal to 3. These are: [1, 2], [3], [3, 0]. Thus, the answer is 3.
 *
 * Function Description
 * Complete the function countNumberOfSubarrays in the editor below.
 * countNumberOfSubarrays has the following parameters:
 *
 *     int arr[n]: the given array of integers
 *     _int k: _the required sum
 * Returns
 * **    **_long_int: _the number of subarrays with sum equal to k.
 *
 * Constraints
 *
 * 1 ≤ _n _≤ 105
 * -109 ≤ _arr[i] _≤ 109
 * _-_109 ≤ k ≤ 109
 */

// https://www.youtube.com/watch?v=20v8zSo2v18

public class NumberOfSubArrayWithKSum {
    public static void main(String[] args) {
        System.out.println(countNumberOfSubarrays(Arrays.asList(1, 2, 3, 0), 3));
    }

    public static long countNumberOfSubarrays(List<Integer> arr, int k) {
        // Write your code here
        Long count = 0L;
        HashMap<Long, Long> sumMap = new HashMap<>();
        sumMap.put(0L, 1L);
        Long sum = 0L;
        for (Integer integer : arr) {
            sum = sum + integer;
            Long rsum = sum - k;
            if(sumMap.containsKey(rsum)) {
                count = count + sumMap.get(rsum);
            }
            sumMap.put(sum, sumMap.getOrDefault(sum, 0L) + 1);
        }

        return count;

    }
}
