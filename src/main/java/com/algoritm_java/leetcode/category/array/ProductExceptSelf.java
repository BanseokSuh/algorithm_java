package com.algoritm_java.leetcode.category.array;


import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4};
        int[] nums2 = {-1,1,0,-3,3};

        int[] result1 = solution(nums1);
        int[] result2 = solution(nums2);

        System.out.println("result1 = " + Arrays.toString(result1));
        System.out.println("result2 = " + Arrays.toString(result2));
    }

    // solution2
    public static int[] solution(int[] nums) {
        int N = nums.length;
        int[] resultArr = new int[N];

        resultArr[0] = 1;

        for (int i = 1; i < N; i++) {
            resultArr[i] = resultArr[i-1] * nums[i-1];
        }

        int R = 1;
        for (int i = N - 1; i >= 0; i--) {
            resultArr[i] = resultArr[i] * R;

            R = nums[i] * R;
        }

        return resultArr;
    }

      // solution1
//    public static int[] solution(int[] nums) {
//        int N = nums.length;
//        int[] leftMultiSum = new int[N];
//        int[] rightMultiSum = new int[N];
//        int[] resultArr = new int[N];
//
//        leftMultiSum[0] = 1;
//        rightMultiSum[N-1] = 1;
//
//        for (int i = 1; i < N; i++) {
//            leftMultiSum[i] = nums[i - 1] * leftMultiSum[i - 1];
//        }
//
//        for (int i = N - 2; i >= 0; i--) {
//            rightMultiSum[i] = nums[i + 1] * rightMultiSum[i + 1];
//        }
//
//        for (int i = 0; i < N; i++) {
//            resultArr[i] = leftMultiSum[i] * rightMultiSum[i];
//        }
//
//        return resultArr;
//    }
}
