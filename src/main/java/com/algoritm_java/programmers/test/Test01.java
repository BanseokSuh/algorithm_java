package com.algoritm_java.programmers.test;

import java.util.Arrays;

public class Test01 {
    public static void main(String[] args) {
        String s1 = "abababab";
        String s2 = "abcabcabd";

        int answer1 = solution(s1);
        int answer2 = solution(s2);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
    }

    /**
     * 문제 접근
     * 핵심 알고리즘
     * 시간복잡도
     * 다른 방식
     */
    public static int solution(String s) {
        /*

         */
        int len = s.length();
        int halfLen = len / 2 + 1;
        int result = len;

        char[] arr = s.toCharArray();

        StringBuffer sb = new StringBuffer(len);

        System.out.println("len = " + len);
        System.out.println("halfLen = " + halfLen);
        System.out.println("arr = " + Arrays.toString(arr));

        for (int i = 1; i < halfLen; i++) {
            sb.append(arr[i - 1]);

            if (len % i == 0) {
                String subStr = sb.toString();
                StringBuffer sb2 = new StringBuffer(len);

                int cnt = len / i;
                sb2.append(subStr.repeat(cnt));

                if (sb2.toString().equals(sb2)) {
                    result = subStr.length();
                    break;
                }
            }
        }



        return result;
    }
}
