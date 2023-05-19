package com.example.practice.ns;

class LCMFirstN {
    public static void main(String[] args) {
        System.out.println(findMin(6));
    }
    static int divisor(int a, int b) {
        int rem = a % b;
        if (rem != 0)
            return divisor(b, rem);
        else
            return b;
    }
    // Function returns the lcm of first n numbers
    static int findMin(int n) {
        int ans = 1;
        for (int i = 1; i <= n; i++)
            ans = (ans * i) / divisor(ans, i);
        return ans;
    }
}