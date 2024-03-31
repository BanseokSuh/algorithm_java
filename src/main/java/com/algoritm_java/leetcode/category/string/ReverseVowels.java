package com.algoritm_java.leetcode.category.string;

public class ReverseVowels {

    public static void main(String[] args) {
        String arg1 = "hello";
        String arg2 = "leetcode";

        String result1 = solution(arg1);
        String result2 = solution(arg2);

        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
    }

    public static String solution(String s) {
        char[] charArr = s.toCharArray();

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char leftChar = charArr[left];
            char rightChar = charArr[right];

            if (!isVowel(leftChar)) {
                left++;
                continue;
            }

            if (!isVowel(rightChar)) {
                right--;
                continue;
            }

            char tmp = rightChar;
            charArr[right] = leftChar;
            charArr[left] = tmp;

            left++;
            right--;
        }

        return new String(charArr);
    }

    static boolean isVowel(char c) {
        return (
                c == 'a'
                || c == 'e'
                || c == 'i'
                || c == 'o'
                || c == 'u'
                || c == 'A'
                || c == 'E'
                || c == 'I'
                || c == 'O'
                || c == 'U'
        );
    }
}
