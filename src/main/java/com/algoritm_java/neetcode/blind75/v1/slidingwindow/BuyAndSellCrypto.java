package com.algoritm_java.neetcode.blind75.v1.slidingwindow;

public class BuyAndSellCrypto {
    public static void main(String[] args) {
        int[] prices1 = { 10, 1, 5, 6, 7, 1 }; // 6
        int[] prices2 = { 10, 8, 7, 5, 2 }; // 0
        int[] prices3 = { 1, 2, 5, 3, 10, 7, 2, 100 }; // 0

        int answer1 = mySolution(prices1);
        int answer2 = mySolution(prices2);
        int answer3 = mySolution(prices3);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
        System.out.println("answer3 = " + answer3);
    }

    /**
     * 문제 접근
     *   two pointer 방식으로 접근
     * 핵심 알고리즘
     *   if - else 에서 'else' 구문
     *   왼쪽 요소보다 오른쪽 요소가 작을 때, 왼쪽 요소에 오른쪽 요소 값을 할당함으로써 불필요한 움직임을 줄임
     * 시간복잡도
     *   O(N)
     * 다른 방식
     */
    public static int mySolution(int[] prices) {
        /*
         * Return the maximum profit you can achieve.
         * You may choose to not make any transactions, in which case the profit would be 0.
         */
        int max = 0;
        int lIdx = 0;
        int rIdx = 1;

        while (rIdx < prices.length) {
            int lVal = prices[lIdx];
            int rVal = prices[rIdx];

            if (lVal < rVal) {
                max = Math.max(max, rVal - lVal);
            } else {
                lIdx = rIdx;
            }
            rIdx++;
        }

        return max;
    }
    public static String refSolution(int a) {
        return null;
    }
}
