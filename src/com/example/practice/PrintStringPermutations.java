package com.example.practice;

import java.util.ArrayList;
import java.util.List;

public class PrintStringPermutations {
    public static void main(String[] args) {
        String input = "ABC";
        List<String> result = new ArrayList<>();
        permute(input, result, 0, input.length()-1);
        result.forEach(System.out::println);
//        permute(input, "");
    }

    // 1st Approach - Backtracking
    private static void permute(String input, List<String> result, int start, int end) {
        if(start == end){
            result.add(input);
            return;
        }
        for (int i = start; i <= end; i++) {
            input = swap(start, i, input);
            permute(input, result, start+1, end);
            input = swap(start, i, input);
        }
    }

    private static String swap(int i, int j, String input) {
        char[] ch = input.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return String.valueOf(ch);
    }

    // 2nd Approach
    static void permute(String s , String answer)
    {
        if (s.length() == 0)
        {
            System.out.print(answer + "  ");
            return;
        }

        for(int i = 0 ;i < s.length(); i++)
        {
            char ch = s.charAt(i);
            String left_substr = s.substring(0, i);
            String right_substr = s.substring(i + 1);
            String rest = left_substr + right_substr;
            permute(rest, answer + ch);
        }
    }


}
