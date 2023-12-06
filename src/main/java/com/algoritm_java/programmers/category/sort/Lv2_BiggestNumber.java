package com.algoritm_java.programmers.category.sort;

import java.util.Arrays;

public class Lv2_BiggestNumber {
    public static String solution(int[] numbers) {
        /**
         * 방법1.
         * - String 배열로 만들어서 sort (아스키 코드 순으로 정렬)
         */
        String[] numStrArr = Arrays.stream(numbers)
                                .mapToObj(Integer::toString)
                                .toArray(String[]::new);

        /**
         * A.compareTo(B)
         * - A == B -> 0
         * - A > B -> 양수
         * - A < B -> 음수
         *
         * "3"+"30" compareTo "30"+"3" -> 양수 리턴 ->
         */
        Arrays.sort(numStrArr, (a, b) -> (b + a).compareTo(a + b));

        if (numStrArr[0].equals("0")) {
            return "0";
        }

        return String.join("", numStrArr);
    }

    public static void main(String[] args) {

        int[] numbers1 = {6, 10, 2};
        int[] numbers2 = {3, 30, 34, 5, 9};

        String answer1 = solution(numbers1);
        String answer2 = solution(numbers2);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
    }
}
