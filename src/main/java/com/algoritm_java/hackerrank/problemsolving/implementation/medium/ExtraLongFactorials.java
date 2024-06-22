package com.algoritm_java.hackerrank.problemsolving.implementation.medium;

import java.math.BigInteger;

public class ExtraLongFactorials {
    public static void main(String[] args) {

        BigInteger answer1 = solution(10);
        BigInteger answer2 = solution(20);
        BigInteger answer3 = solution(30);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
        System.out.println("answer3 = " + answer3);
    }

    /**
     * 문제 접근
     * - factorial 구하기
     * 핵심 알고리즘
     * - for loop를 통해 누적값 곱
     * - BigInteger 클래스 및 메서드 활용하여 연산 처리
     * 시간복잡도
     * - O(N) - for loop
     * 다른 풀이
     * - ??
     */
    public static BigInteger solution(int n) {
        BigInteger result = BigInteger.ONE;

        for (BigInteger i = BigInteger.ONE; i.compareTo(BigInteger.valueOf(n)) <= 0; i = i.add(BigInteger.ONE)) {
            result = result.multiply(i);
        }

        System.out.println(result);

        return result;
    }

}
