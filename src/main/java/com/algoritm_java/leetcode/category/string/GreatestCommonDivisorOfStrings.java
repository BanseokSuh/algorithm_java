package com.algoritm_java.leetcode.category.string;

public class GreatestCommonDivisorOfStrings {
    public static void main(String[] args) {
        String a = "ABCABC";
        String b = "ABC";

        String a2 = "ABABAB";
        String b2 = "ABAB";

        String result1 = solution(a, b);
        String result2 = solution(a2, b2);

        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
    }

    public static String solution(String a, String b) {
        if (!((a + b).equals(b + a))) {
            return "";
        }

        int aLength = a.length();
        int bLength = b.length();
        int maxCommon = 0;

        int shortLength = Math.min(aLength, bLength);

        for (int i = 1; i <= shortLength; i++) {
            if (aLength % i == 0 && bLength % i == 0) {
                maxCommon = i;
            }
        }

        return a.substring(0, maxCommon);
    }
}
