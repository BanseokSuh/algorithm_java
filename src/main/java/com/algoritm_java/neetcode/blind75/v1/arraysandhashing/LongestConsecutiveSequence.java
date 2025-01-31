package com.algoritm_java.neetcode.blind75.v1.arraysandhashing;

import java.util.*;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {

        int[] nums1 = { 2, 20, 4, 10, 3, 4, 5 }; // Output: 4
        int[] nums2 = { 0, 3, 2, 5, 4, 6, 1, 1 }; // Output: 7
        int[] nums3 = {};
        int[] nums4 = { 9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6 }; // Output: 7

        int answer1 = solution(nums1);
        int answer2 = solution(nums2);
        int answer3 = solution(nums3);
        int answer4 = solution(nums4);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
        System.out.println("answer3 = " + answer3);
        System.out.println("answer4 = " + answer4);
    }

    /**
     * 문제 접근
     * 핵심 알고리즘
     * 시간복잡도
     * 다른 방식
     */
    public static int solution(int[] nums) {
        /*
            - O(nlogn)
            - sortedSet
            - There should be a better way
         */
        if (nums.length == 0) return 0;

        SortedSet<Integer> sortedSet = new TreeSet<>();

        for (int num : nums) {
            sortedSet.add(num);
        }

        List<Integer> list = new ArrayList<>(sortedSet);
        List<Integer> countList = new ArrayList<>();

        int prev = list.get(0);
        int count = 1;

        for (int i = 1; i < list.size(); i++) {
            int cur = list.get(i);

            if (cur == prev + 1) {
                count++;
            } else {
                count = 1;
            }
            countList.add(count);
            prev = cur;
        }

        return countList.isEmpty() ? count : Collections.max(countList);
    }
}
