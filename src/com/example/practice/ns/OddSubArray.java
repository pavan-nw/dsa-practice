package com.example.practice.ns;

import java.util.Scanner;

public class OddSubArray{

    public static long countSubarrays(long n){
        return (n*(n+1))/2;
    }
    public static long oddArray(){
        // input
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int i = 0, count = 0, totalSubArrays = 0;
        boolean wasLastNumberOdd = false;
        for(i = 0; i < arr.length; i++) {
            if(arr[i] % 2 == 1 && !wasLastNumberOdd) {
                count = 1;
                wasLastNumberOdd = true;
            }
            // continuation
            // last number was odd and current number is also odd
            else if(wasLastNumberOdd && arr[i] % 2 == 1) {
                count++;
            }
            // ending a sequence
            // last number was odd and current number is even
            else if(wasLastNumberOdd && arr[i] % 2 == 0) {
                totalSubArrays += countSubarrays(count);
                wasLastNumberOdd = false;
                count = 0;
            }
        }
        if(wasLastNumberOdd) {
            totalSubArrays += countSubarrays(count);
            wasLastNumberOdd = false;
        }
        System.out.println(totalSubArrays);
        return totalSubArrays;
    }

    public static void main(String[] args){
        oddArray();
    }
}