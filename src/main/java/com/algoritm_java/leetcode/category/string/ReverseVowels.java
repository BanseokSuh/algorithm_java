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
            if (!isVowel(charArr[left])) {
                left++;
                continue;
            }

            if (!isVowel(charArr[right])) {
                right--;
                continue;
            }

            char tmp = charArr[right];
            charArr[right] = charArr[left];
            charArr[left] = tmp;

            left++;
            right--;
        }

        return new String(charArr);

//        StringBuilder sb = new StringBuilder();
//        StringBuilder tmpStr = new StringBuilder();
//
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (isVowel(c)) {
//                sb.append('*');
//                tmpStr.append(c);
//            } else {
//                sb.append(c);
//            }
//        }
//
//        for (int i = tmpStr.length() - 1; i >= 0; i--) {
//            char c = tmpStr.charAt(i);
//            int idx = sb.indexOf("*");
//
//            sb.replace(idx, idx + 1, String.valueOf(c));
//        }
//
//        return sb.toString();
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
