package com.algoritm_java.leetcode.category.array;

public class IncreasingTriplet {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5};
        int[] nums2 = {5,4,3,2,1};
        int[] nums3 = {20,100,10,12,5,13};

        boolean result1 = solution(nums1);
        boolean result2 = solution(nums2);
        boolean result3 = solution(nums3);

        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
        System.out.println("result3 = " + result3);
    }

    public static boolean solution(int[] nums) {
        int firstNum = Integer.MAX_VALUE;
        int secondNum = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= firstNum) {
                firstNum = num;
            } else if (num <= secondNum) {
                secondNum = num;
            } else {
                return true;
            }
        }

        return false;
    }
}
