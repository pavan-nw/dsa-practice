package com.example.practice.twillio;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Twilio customers sometimes request to purchase vanity phone numbers.
 * These vanity numbers are designed to be unique to the customer's brand and memorable to their end user.
 * An example of this is 1-800-FLOWERS, which translates to 1-800-3569377.
 * Here, each letter in the vanity code (FLOWERS) corresponds to a digit on the ** T9 keypad map**.
 * So, F maps to 3, L to 5, O to 6 and so on, giving us 3569377.
 * Customers typically search Twilio's phone number inventory for such vanity codes.
 * Given an array of one or more vanity codes and an array of phone numbers,
 * write a function to find all phone numbers that match one or more vanity codes.
 * ****The output must be a sorted array of unique phone numbers from the input array of numbers.
 *
 * Function Description
 * Complete the function vanity in the editor below.
 *
 * vanity has the following parameter(s):
 * _    codes[codes[0],...codes[c-1]]_: an array of strings (vanity codes)
 * _    numbers[numbers[0],...numbers[n-1]]:_  an array of strings (phone numbers)
 * _vanity _should return a sorted array of phone numbers that match one or more vanity codes.
 *
 * Constraints
 *
 * The input numbers array may have repeat elements.
 * The output must be a sorted array of unique numbers.
 * Vanity codes will only consist of uppercase letters (A-Z).
 * All vanity codes will be of shorter length than all phone numbers.
 * The output array should be subset of the input array of phone numbers.
 * Vanity codes can appear anywhere in the number, including country or area codes.
 * Phone numbers will be in the E.164 format i.e. a plus (+) followed by up to 15 digits (0-9).
 *
 * Sample Case
 *
 * Sample Input For Custom Testing
 * 3 TWLO CODE HTCH 5 +17474824380 +14157088956 +919810155555 +15109926333 +1415123456
 *
 * Sample Output
 * +14157088956 +15109926333 +17474824380
 *
 * Explanation
 * TWLO matches +14157088956 (+1415708-TWLO)
 * CODE matches +15109926333 (+151099-CODE-3)
 * HTCH matches +17474824380 (+1747-HTCH-380)
 */

// https://www.hackerrank.com/challenges/vanity-number-search/problem
public class VanityNumberSearch {

    public static void main(String[] args) {
        List<String> vanityCodes = Arrays.asList("TWLO", "CODE", "HTCH");
        List<String> numbers = Arrays.asList("+17474824380", "+14157088956", "+919810155555", "+15109926333", "+1415123456");
        List<String> output = vanity(vanityCodes, numbers);
        System.out.println(String.join(" ", output));
    }

    public static List<String> vanity(List<String> codes, List<String> numbers) {

        HashMap<Integer, List<Character>> keypad = new HashMap<>();
        keypad.put(2, Arrays.asList('A','B','C'));
        keypad.put(3, Arrays.asList('D','E','F'));
        keypad.put(4, Arrays.asList('G','H','I'));
        keypad.put(5, Arrays.asList('J','K','L'));
        keypad.put(6, Arrays.asList('M','N','O'));
        keypad.put(7, Arrays.asList('P','Q','R','S'));
        keypad.put(8, Arrays.asList('T','U','V'));
        keypad.put(9, Arrays.asList('W','X','Y','Z'));

        List<String> nums = codes
                .parallelStream()
                .map(c -> getMatchingNumber(c, keypad))
                .collect(Collectors.toList());

        List<String> output = numbers
                .parallelStream()
                .distinct()
                .filter(n1 -> nums.parallelStream().anyMatch(n2 -> n1.indexOf(n2) != -1))
                .collect(Collectors.toList());

        Collections.sort(output);

        // output.forEach(a -> System.out.print(a + " "));

        return output;

    }

    public static String getMatchingNumber(String code, Map<Integer, List<Character>> keypad) {
        String res = "";
        for (int i = 0; i < code.length(); i++) {
            for (Integer key : keypad.keySet()) {
                List<Character> list = keypad.get(key);
                if(list.contains(code.charAt(i))){
                    res = res + key;
                }
            }
        }
        return res;
    }
}
