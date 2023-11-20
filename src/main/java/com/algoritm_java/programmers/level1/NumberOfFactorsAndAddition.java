package com.algoritm_java.programmers.level1;

public class NumberOfFactorsAndAddition {
    public static int solution(int left, int right) {
        int cnt = 0;

        for (int i = left; i <= right; i++) {
            int tmpCnt = 0;
            for (int j = 1; j * j <= i; j++) {
                if (j * j == i) {
                    tmpCnt++;
                } else if (i % j == 0) {
                    tmpCnt += 2;
                }
            }
            System.out.println("tmpCnt = " + tmpCnt);
            if (tmpCnt % 2 == 0) {
                cnt += i;
            } else {
                cnt -= i;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int left1 = 13;
        int right1 = 17;

        int left2 = 24;
        int right2 = 27;

        int answer1 = solution(left1, right1);
        int answer2 = solution(left2, right2);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer1 = " + answer2);
    }
}
