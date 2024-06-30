package com.algoritm_java.neetcode.blind75.arraysandhashing;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {

        int[] nums1 = {1, 2, 4, 6}; // Output: [48, 24, 12, 8]
        int[] nums2 = {-1, 0, 1, 2, 3}; // Output: [0, -6, 0, 0, 0]

        int[] answer1 = solution(nums1);
        int[] answer2 = solution(nums2);

        System.out.println("answer1 = " + Arrays.toString(answer1));
        System.out.println("answer2 = " + Arrays.toString(answer2));
    }

    /**
     * 문제 접근
     * 핵심 알고리즘
     * 시간복잡도
     * 다른 방식
     */
    public static int[] solution(int[] nums) {
        /*
            - The time complexity should be  O(N)
            - No nested loop needed
            - Get 2 arrays of left-multiplied and right multiplied
            - multiple both arrays

            - leftMultipleArr[i] = leftMultipleArr[i - 1] * nums[i];
         */
        int initVal = 1;

        int[] resultArr = new int[nums.length];
        int[] leftMultiArr = new int[nums.length];
        int[] rightMultiArr = new int[nums.length];

        // Set the initVal
        leftMultiArr[0] = initVal; // leftMultiArr [1, 0, 0, 0]
        rightMultiArr[nums.length - 1] = initVal; // rightMultiArr [0, 0, 0, 1]

        for (int i = 1; i < nums.length; i++) {
            leftMultiArr[i] = leftMultiArr[i - 1] * nums[i - 1];
        }

        for (int i = nums.length - 2; i > 0 ; i--) {
            rightMultiArr[i] = rightMultiArr[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            resultArr[i] = leftMultiArr[i] * rightMultiArr[i];
        }

        return resultArr;
    }
}
