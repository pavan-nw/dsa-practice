package com.example.practice.dp;

// https://www.youtube.com/watch?v=0NPYcQQWJ3Q

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FindMaxSumIncreasingSubsequence {
    public static void main(String[] args) {
        int[] a = {1,101,2,3,100,4,5};
//        int[] a = {1,-101,2,3,-100,4,5};
//        int[] a = {3,4,5,10};
//        int[] a = {10,5,4,3};
        int n = a.length;
        int[] mis = new int[n];
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        for (int i = 0; i < mis.length; i++) {
            mis[i] = a[i];
            List<Integer> list = new ArrayList<>();
            list.add(a[i]);
            map.put(mis[i], list);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(a[i] > a[j] && mis[i] < mis[j] + a[i]) {
                    List<Integer> list = new ArrayList<>(map.get(mis[j]));
                    mis[i] = mis[j] + a[i];
                    list.add(a[i]);
                    map.put(mis[i], list);
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
        List<Integer> finalList = map.get(max);
        if(finalList != null) {
         finalList.forEach(System.out::println);
        }
    }
}
