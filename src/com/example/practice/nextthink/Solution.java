package com.example.practice.nextthink;

class Solution {
    public static int solution(int N) {
        String numStr = Integer.toString(N);
        boolean first = false;
        StringBuilder ans = new StringBuilder();

        if (N > 0) {
            for (int i = 0; i < numStr.length(); i++) {
                char c = numStr.charAt(i);
                if(!first && c == '5') {
                    first = true;
                } else {
                    ans.append(c);
                }
            }
            return Integer.parseInt(String.valueOf(ans));
        }
        else {
            for (int i = numStr.length()-1; i >= 1; i--) {
                char c = numStr.charAt(i);
                if(!first && c == '5') {
                    first = true;
                } else {
                    ans.append(c);
                }
            }
            return -Integer.parseInt(String.valueOf(ans.reverse()));
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(-5000));
    }
}

