package com.algoritm_java.neetcode.blind75.v1.twopointers;

public class ValidPalindrome {
    public static void main(String[] args) {

        String s1 = "Was it a car or a cat I saw?";
        String s2 = "tab a cat";

        boolean answer1 = solution(s1);
        boolean answer2 = solution(s2);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
    }

    /**
     * 문제 접근
     * 핵심 알고리즘
     * 시간복잡도
     * 다른 방식
     */
    public static boolean solution(String s) {
        /*
            1. Remove all the space and special characters.
            2. Convert string to char[]
            3. Loop
         */
        char[] arr = s.replaceAll("[^a-zA-Z0-9]", "")
                .trim()
                .toLowerCase()
                .toCharArray();

        int len = arr.length;

        for (int i = 0; i < len; i++) {
            if (arr[i] != arr[len - 1 - i]) {
                return false;
            }
        }

        return true;
    }
}
