package com.example.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Instructions
 *
 * Given an input string of arbitrary length, output SMS-compliant segments with suffixes.
 *
 * A SMS-compliant segment is of length 160 characters or less.
 * Do not generate segments if the input fits in a single message.
 * A segment suffix looks like "(1/5)" for the first of five segments.
 * The segment content and suffix must both fit in the segment.
 * You must complete the function/method stub to return an array of message segments.
 *
 * Input Constraints
 *
 * Inputs will only consist of A-Z, a-z, spaces ( ), commas (,) and periods (.)
 * Your implementation can expect a maximum of 9 segments per input.
 *
 * Extra Credit Case
 *
 * The third test case has an additional output constraint: do not split words between segments!
 * You should be able to iterate on your existing implementation.
 *
 * Words will be delimited by a single space. Do not split on any other punctuation.
 * You do not need to account for "unbreakable" i.e extremely long words in the input.
 * Spaces between words should be preserved in the first segment unless that violates
 * the SMS length constraint, in which case the space should be included in the next segment.
 *
 * Sample Test Case
 * Sample Input
 * Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis partu sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore ver rup. Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa.
 *
 * Sample Output
 * Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis partu (1/3) sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore ver (2/3) rup. Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa.(3/3)
 */

// https://www.hackerrank.com/challenges/sms-splitting/problem

public class SMSSplitting {
    public static void main(String[] args) {
        String message = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. " +
                "Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et " +
                "magnis dis partu sed ut perspiciatis unde omnis iste natus error sit voluptatem " +
                "accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore ver rup. " +
                "Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, " +
                "musica, sport etc, litot Europa.";
        List<String> result = segments(message);
        result.forEach(System.out::println);
    }


    /*
     * Complete the 'segments' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING message as parameter.
     */

    public static List<String> segments(String message) {

        int size = message.length();
        List<String> segmentList = new ArrayList<>();
        if(size <= 160) {
            segmentList.add(message);
        } else {
            int n  = size / 155;
            int count  = 1;
            int start = 0;
            int end = 155;
            while(count <= n+1) {
                String segment = getSegment(message, start, end, size);
                int diff = 0;
                if(count != n+1) {
                    //System.out.println(segment);
                    if(!segment.endsWith(" ") && message.charAt(end) != ' ') {
                        int spaceIndex = segment.lastIndexOf(" ");
                        diff = 155 - spaceIndex;
                        segment = getSegment(segment, 0, spaceIndex+1, 155);
                    }
                }
                String segmentWithSuffix = segment+"("+(count)+"/"+(n+1)+")";
                segmentList.add(segmentWithSuffix);
                //System.out.println(segmentWithSuffix);
                if(diff != 0) {
                    start = start + 155 - diff+1;
                    end = end + 155 - diff+1;
                    //  System.out.println("diff: " + diff);
                } else {
                    start = start + 155 - diff;
                    end = end + 155 - diff;
                }
                count = count +1;
            }
        }
        return segmentList;
    }

    public static String getSegment(String message, int start, int end, int size) {
        if(end<size) {
            return message.substring(start, end);
        } else {
            return message.substring(start);
        }
    }
}
