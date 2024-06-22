package com.algoritm_java.programmers.test;

public class Test02 {
    public static void main(String[] args) {
        String s1 = "abababab";
        String s2 = "abcabcabd";

        int answer1 = solution(s1);
//        int answer2 = solution(s2);

//        System.out.println("answer1 = " + answer1);
//        System.out.println("answer2 = " + answer2);
    }

    /**
     * 문제 접근
     * 핵심 알고리즘
     * 시간복잡도
     * 다른 방식
     */
    public static int solution(String s) {
        int len = s.length();

        for (int i = 1; i <= len / 2; i++) {
            System.out.println("i = " + i);

            if (len % i == 0) {
                String subStr = s.substring(0, i);
                System.out.println("subStr = " + subStr);

                StringBuilder sb = new StringBuilder();

                sb.append(subStr.repeat(len / i));
                System.out.println("sb = " + sb);

                if (sb.toString().equals(s)) {
                    return i;
                }
            }
        }
        return len;
    }
}
