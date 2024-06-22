package com.algoritm_java.hackerrank.problemsolving.implementation.easy;

import java.util.*;

public class CircularArrayRotation {
    public static void main(String[] args) {
        List<Integer> a1 = new ArrayList<>(Arrays.asList(3, 4, 5, 6, 7, 8));
        int k1 = 2;
        List<Integer> queries1 = new ArrayList<>(Arrays.asList(1, 2));

//        List<Integer> a2 = new ArrayList<>(Arrays.asList(515, 100000, 500));
//        int k2 = 2;
//        List<Integer> queries2 = new ArrayList<>(Arrays.asList(1, 2));

        List<Integer> answer1 = solution(a1, k1, queries1);
//        List<Integer> answer2 = solution(a2, k2, queries2);

        System.out.println("answer1 = " + answer1);
    }

    /**
     * 문제 접근
     * 핵심 알고리즘
     * 시간복잡도
     * 다른 방식
     *
     * 노트
     * 0 > 3,4,5
     * 1 > 5,3,4
     * 2 > 4,5,3
     */
    public static List<Integer> solution(List<Integer> a, int k, List<Integer> queries) {

        List<Integer> result = new ArrayList<>();
        int s = a.size();
        k %= s; // k = k % s
        for (Integer query : queries) { // O(n)
            /*
            Get the queried index, then find the initial index of the element
            in the current queried index.
            After that, add that element's value to the list l.
            */
            result.add(a.get((query + s - k) % s)); // O(1)
        }
        System.out.println("result = " + result);
        return result;

//        ================================================================== 1 test case not passed
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        List<Integer> result = new ArrayList<>();
//        for (int i = 0; i < a.size(); i++) {
//            int value = i + k >= a.size() ? i + k - a.size() : i + k;
//
//            hashMap.put(value, a.get(i));
//        }
//        for (Integer query : queries) {
//            result.add(hashMap.getOrDefault(query, 0));
//        }
//        System.out.println("result = " + result);
//        return result;
    }

}
