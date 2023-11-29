package com.algoritm_java.programmers.category.hash;

import java.util.HashSet;

public class Lv1_Ponketmon {
    public static int solution(int[] nums) {
        /**
         * [hashMap]
         * nums를 순회하여 hashMap 생성
         * - key: num
         * - value: 1++
         * int availableNum = nums / 2;
         * availableNum과 hashMap의 key의 length 중 더 작은 수 return
         *
         * [hashSet]
         * - hashSet은 중복을 제거해주기 때문에 더 나은 방법
         */

//        HashMap<Integer, Integer> hashMap = new HashMap();
//        for (int num : nums) {
//            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
//        }
//        int lengthOfKind = hashMap.size();
//        int availableNum = nums.length / 2;
//
//        return Math.min(availableNum, lengthOfKind);

        HashSet<Integer> hashSet = new HashSet();

        for (int num : nums) hashSet.add(num);

        int lengthOfKind = hashSet.size();
        int availableNum = nums.length / 2;

        return Math.min(availableNum, lengthOfKind);
    }

    public static void main(String[] args) {
        int[] nums1 = {3,1,2,3};
        int[] nums2 = {3,3,3,2,2,4};
        int[] nums3 = {3,3,3,2,2,2};

        int answer1 = solution(nums1);
        int answer2 = solution(nums2);
        int answer3 = solution(nums3);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
        System.out.println("answer3 = " + answer3);
    }
}
