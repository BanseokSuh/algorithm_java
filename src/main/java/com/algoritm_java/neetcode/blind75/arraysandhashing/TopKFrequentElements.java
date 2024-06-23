package com.algoritm_java.neetcode.blind75.arraysandhashing;

import java.util.*;

import static java.util.Map.Entry.comparingByValue;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums1 = new int[] { 1,2,2,3,3,5,5,5,5,5 };
        int k1 = 2;

        int[] nums2 = new int[] { 7,7 };
        int k2 = 1;

        int[] nums3 = new int[] { 1,1,1,2,3,3 };
        int k3 = 2;

        int[] answer1 = solution(nums1, k1);
        int[] answer2 = solution(nums2, k2);
        int[] answer3 = solution(nums3, k3);

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
    public static int[] solution(int[] nums, int k) {
        /*
            v1
            Declare sorted map
            Loop nums
            Set the map with the key by num and the value by count
         */
        int[] result = new int[k];

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        System.out.println("## hashMap = " + hashMap);

        /*
            hashMap을 value 기준으로 sort하기 (desc)
         */
        // Convert hashMap to entrySet
        Set<Map.Entry<Integer, Integer>> entrySet = hashMap.entrySet();
        System.out.println("## entrySet = " + entrySet);

        // Convert entrySet to list
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(entrySet);
        System.out.println("## list = " + list);

        // Sort list by the value of set order by desc
        list.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());
        System.out.println("## list-sorted = " + list);

        // Set result int array
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getKey();
        }

        System.out.println();
        return result;
    }
}
