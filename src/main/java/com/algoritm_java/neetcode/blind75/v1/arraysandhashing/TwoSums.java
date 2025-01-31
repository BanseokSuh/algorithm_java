package com.algoritm_java.neetcode.blind75.v1.arraysandhashing;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSums {
    public static void main(String[] args) {
        int[] nums1 = {3,4,5,6};
        int target1 = 7;

        int[] nums2 = {4,5,6};
        int target2 = 10;

        int[] nums3 = {5,5};
        int target3 = 10;

        int[] answer1 = solution(nums1, target1);
        int[] answer2 = solution(nums2, target2);
        int[] answer3 = solution(nums3, target3);

        System.out.println("answer1 = " + Arrays.toString(answer1));
        System.out.println("answer2 = " + Arrays.toString(answer2));
        System.out.println("answer3 = " + Arrays.toString(answer3));
    }

    /**
     * 문제 접근
     * 핵심 알고리즘
     * 시간복잡도
     * 다른 방식
     */
    public static int[] solution(int[] nums, int target) {
        /*
            v1
            Nested for loop
         */
//        int[] result = new int[2];
//
//        for (int i = 0; i < nums.length; i++) {
//            int diff = target - nums[i];
//
//            int[] backArr = Arrays.copyOfRange(nums, i + 1, nums.length);
//
//            int pairIdx = -1;
//            for (int j = 0; j < backArr.length; j++) {
//                if (backArr[j] == diff) {
//                    pairIdx = j;
//                    break;
//                }
//            }
//
//            if (pairIdx != -1) {
//                result[0] = i;
//                result[1] = i + 1 + pairIdx;
//            }
//        }
//
//        return result;

        /*
            v2
            1. Declare a map to set the element or nums
            2. Loop to calculate the diff
            3. Set the map with the key by nums[i] and value by index of it
            4. If there's the diff in the map, return the value of the diff(which is the index of the value) and current index
         */
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (map.containsKey(diff)) {
                return new int[] {map.get(diff), i};
            }

            map.put(nums[i], i);
        }

        return new int[0];
    }
}
