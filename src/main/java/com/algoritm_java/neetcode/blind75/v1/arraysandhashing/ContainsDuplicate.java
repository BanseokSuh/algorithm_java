package com.algoritm_java.neetcode.blind75.v1.arraysandhashing;

import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 3};
        int[] nums2 = {1, 2, 3, 4};

        boolean answer1 = solution(nums1);
        boolean answer2 = solution(nums2);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
    }

    /**
     * 문제 접근 : return asap
     * 핵심 알고리즘 : HashSet
     * 시간복잡도 : O(n)
     * 다른 방식
     */
    public static boolean solution(int[] nums) {
        // Use map
        // If not exist, add the element to the map
        // If exist return true;
        // return false;

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }

        return false;
    }
}
