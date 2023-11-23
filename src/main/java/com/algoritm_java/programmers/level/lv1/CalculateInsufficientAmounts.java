package com.algoritm_java.programmers.level.lv1;

public class CalculateInsufficientAmounts {
    public static long solution(int price, int money, int count) {
        long totalAmount = 0;

        for (int i = 1; i <= count; i++) {
            totalAmount += price * i;
        }

        long required = totalAmount - money;

        return Math.max(required, 0);
    }

    public static void main(String[] args) {
        int price1 = 3;
        int money1 = 20;
        int count1 = 4;

        long answer1 = solution(price1, money1, count1);

        System.out.println("answer1 = " + answer1);
    }
}
