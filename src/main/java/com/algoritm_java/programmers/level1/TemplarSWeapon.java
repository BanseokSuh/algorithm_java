package com.algoritm_java.programmers.level1;

import java.util.Arrays;

public class TemplarSWeapon {
    public static int solution(int number, int limit, int power) {
        /**
         * number까지 loop 돌며 1~number의 각각 약수 구하기
         * aliquotArr 순회하며 limit을 넘은 요소에 power값 재할당
         */
        int[] aliquotArr = new int[number];

        for (int i = 1; i <= number; i++) {
            aliquotArr[i - 1] = countAliquot(i);
        }

        for (int i = 0; i < aliquotArr.length; i++) {
            if (aliquotArr[i] > limit) aliquotArr[i] = power;
        }

        return Arrays.stream(aliquotArr).sum();
    }

    /**
     * 약수 구하기
     * @param number
     * @return
     */
    private static int countAliquot(int number) {
        int count = 0;
        for (int i = 1; i * i <= number; i++) {
            if (i * i == number) count++; // i가 제곱근일 경우 더하기 1
            else if (number % i == 0) count += 2; // i가 제곱근이 아닐 경우 더하기 2 (1로 나누어 떨어지면 곱셈의 대상이 되는 16에 대해서도 count++)
        }
        return count;
    }

    public static void main(String[] args) {
        int number1 = 5;
        int limit1 = 3;
        int power1 = 2;

        int number2 = 10;
        int limit2 = 3;
        int power2 = 2;


        int answer1 = solution(number1, limit1, power1);
        int answer2 = solution(number2, limit2, power2);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
    }
}
