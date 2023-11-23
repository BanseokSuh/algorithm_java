package com.algoritm_java.programmers.level.lv1;

public class NumberWhoseRemainderIs1 {
    public static int solution(int n) {
        int result = 0;

        for (int x = 1; x <= n; x++) {
            if (n % x == 1) {
                result = x;
                break;
            }
        }
        return result;
    }


    public static void main(String[] arg) {
        int test1 = 12;
        int result1 = solution(test1);
        System.out.println("result1 = " + result1);
    }
}
