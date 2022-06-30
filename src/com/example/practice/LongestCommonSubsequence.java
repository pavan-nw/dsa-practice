package com.example.practice;

// https://www.geeksforgeeks.org/printing-longest-common-subsequence/
public class LongestCommonSubsequence {
    // Dynamic Programming implementation of LCS problem in Java

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
            }

            // If not same, then find the larger of two and
            // go in the direction of larger value
            else if (L[i - 1][j] > L[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        // Print the lcs
        System.out.println("Length of longest common sequence is " + lcsLength);
        System.out.print("LCS of " + X + " and " + Y + " is ");
        for (int k = 0; k < lcsLength; k++) {
            System.out.print(lcs[k]);
        }
    }

    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        int m = X.length();
        int n = Y.length();
        lcs(X, Y, m, n);
    }
}
