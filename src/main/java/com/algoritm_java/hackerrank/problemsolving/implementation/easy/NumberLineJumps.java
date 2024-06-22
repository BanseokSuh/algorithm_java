package com.algoritm_java.hackerrank.problemsolving.implementation.easy;

public class NumberLineJumps {
    public static void main(String[] args) {
        int x1 = 2, v1 = 1, x2 = 1, v2 = 2;
        int x11 = 0, v11 = 2, x21 = 5, v21 = 3;

        String answer1 = solution(x1, v1, x2, v2);
        String answer2 = solution(x11, v11, x21, v21);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
    }

    /**
     * 문제 접근
     * 핵심 알고리즘
     * 시간복잡도
     * - O(N) - while문
     * 다른 풀이
     * -
     */
    public static String solution(int x1, int v1, int x2, int v2) {

        int smallX, smallV, bigX, bigV;

        if (x1 < x2) {
            smallX = x1;
            smallV = v1;
            bigX = x2;
            bigV = v2;
        } else {
            smallX = x2;
            smallV = v2;
            bigX = x1;
            bigV = v1;
        }

        while (smallX <= bigX) {
            if (smallX == bigX) {
                return "YES";
            }

            smallX += smallV;
            bigX += bigV;
        }

        return "NO";
    }
}
