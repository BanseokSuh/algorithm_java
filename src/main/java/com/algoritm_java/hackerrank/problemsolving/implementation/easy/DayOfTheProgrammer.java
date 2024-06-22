package com.algoritm_java.hackerrank.problemsolving.implementation.easy;

import java.util.Arrays;

public class DayOfTheProgrammer {
    public static void main(String[] args) {
        int year1 = 1984;

        int answer1 = solution(year1);
//        int answer2 = solution(2);
//        int answer3 = solution(2);

        System.out.println("answer1 = " + answer1);
//        System.out.println("answer2 = " + answer2);
//        System.out.println("answer3 = " + answer3);
    }

    /**
     * 문제 접근
     * 핵심 알고리즘
     * 시간복잡도
     * 다른 방식
     */
    public static int solution(int year) {
        boolean isLeapYear = getIsLeapYear(year);
        int[] daysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] accDaysOfMonth = new int[daysOfMonth.length];

        int tmpAcc = 0;
        for (int i = 0; i < daysOfMonth.length; i++) {
            accDaysOfMonth[i] = tmpAcc + daysOfMonth[i];
            tmpAcc = accDaysOfMonth[i];
        }

        if (isLeapYear) tmpAcc++;

        System.out.println("isLeapYear = " + isLeapYear);
        System.out.println("tmpAcc = " + tmpAcc);
        System.out.println("accDaysOfMonth = " + Arrays.toString(accDaysOfMonth));


        return 0;
    }

    public static boolean getIsLeapYear(int year) {
        return year % 4 == 0;
    }
}
