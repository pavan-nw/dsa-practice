package com.example.practice.dp;

// https://www.geeksforgeeks.org/print-longest-palindromic-subsequence/?ref=gcse

// This is the variation of longest common subsequence of 2 strings problem
// We have to find common subsequence of string and its reverse

public class LongestPalindromeSubsequence {
    // Returns length of LCS for X[0..m-1], Y[0..n-1]
    static void lcs(String X, String Y, int m, int n) {
        int[][] L = new int[m + 1][n + 1];

        // Following steps build L[m+1][n+1] in bottom up
        // fashion. Note that L[i][j] contains lastIndex of LCS
        // of X[0..i-1] and Y[0..j-1]
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    L[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    L[i][j] = L[i - 1][j - 1] + 1;
                } else {
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
                }
            }
        }

        // Following code is used to print LCS
        int lcsLength = L[m][n];
        // Create a character array to store the lcs string
        char[] lcs = new char[lcsLength];

        // Start from the right-most-bottom-most corner and
        // one by one store characters in lcs[]
        int i = m;
        int j = n;
        int lastIndex = lcsLength;
        while (i > 0 && j > 0) {
            // If current character in X and Y are same,
            // then current character is part of LCS
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                // Put current character in result
                lcs[lastIndex - 1] = X.charAt(i - 1);
                // reduce values of i, j and lcsLength
                i--;
                j--;
                lastIndex--;
            } else if (L[i - 1][j] > L[i][j - 1]) {
                // If not same, then find the larger of two and
                // go in the direction of larger value
                i--;
            } else {
                j--;
            }
        }

        // Print the lcs
        System.out.println("Length of longest palindromic subsequence is " + lcsLength);
        System.out.print("Longest palindromic subsequence is: ");
        for (int k = 0; k < lcsLength; k++) {
            System.out.print(lcs[k]);
        }
    }

    public static void main(String[] args) {
        String X = "forgeeksskeegfor";
        int m = X.length();
        lcs(X, new StringBuffer(X).reverse().toString(), m, m);
    }
}
