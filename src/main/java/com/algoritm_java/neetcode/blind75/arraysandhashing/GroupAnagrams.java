package com.algoritm_java.neetcode.blind75.arraysandhashing;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs1 = new String[]{"act", "pots", "tops", "cat", "stop", "hat"}; // Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
        String[] strs2 = new String[]{"x"}; // Output: [["x"]]
        String[] strs3 = new String[]{""}; // Output: [[""]]

        List<List<String>> answer1 = solution(strs1);
        List<List<String>> answer2 = solution(strs2);
        List<List<String>> answer3 = solution(strs3);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
        System.out.println("answer3 = " + answer3);
    }

    /**
     * 문제 접근
     * 핵심 알고리즘
     * 시간복잡도
     * 다른 방식
     */
    public static List<List<String>> solution(String[] strs) {
        /*
            v1
            1. Declare hashMap like the following
                hashMap {
                    String : String[]
                }

            2. Declare isAnagram() {};
            3. Loop

            Failed
         */
//        HashMap<String, List<String>> hashMap = new HashMap<>();
//        List<String> initVal = new ArrayList<>();
//        initVal.add(strs[0]);
//        hashMap.put(strs[0], initVal);
//
//        for (int i = 1; i < strs.length; i++) {
//            String curStr = strs[i];
//            String[] keyArr = hashMap.keySet().toArray(new String[0]);
//
//            for (int j = 0; j < keyArr.length; j++) {
//                String key = keyArr[j];
//
//                if (isAnagram(curStr, key)) {
//                    pushToHashMap(hashMap, key, curStr);
//                } else {
//                    List<String> val = new ArrayList<>();
//                    val.add(curStr);
//                    hashMap.put(curStr, val);
//                }
//            }
//        }
//        return null;

        /*
            v2
            There should be a better way to solve it without using Arrays.sort()
         */
        HashMap<String, List<String>> hashMap = new HashMap<>();

        for (String str : strs) {
            char[] strCharArr = str.toCharArray();
            Arrays.sort(strCharArr);
            String orderedStr = String.valueOf(strCharArr);

            if (!hashMap.containsKey(orderedStr)) {
                hashMap.put(orderedStr, new ArrayList<>());
            }

            hashMap.get(orderedStr).add(str);
        }

        return new ArrayList<>(hashMap.values());
    }

//    public static boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) return false;
//
//        SortedMap<Character, Integer> sSortedMap = new TreeMap<>();
//        SortedMap<Character, Integer> tSortedMap = new TreeMap<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            char sChar = s.charAt(i);
//            char tChar = t.charAt(i);
//
//            sSortedMap.put(sChar, sSortedMap.getOrDefault(sChar, 0) + 1);
//            tSortedMap.put(tChar, tSortedMap.getOrDefault(tChar, 0) + 1);
//        }
//
//        return sSortedMap.equals(tSortedMap);
//    }
//
//    public static void pushToHashMap(HashMap<String, List<String>> hashMap, String key, String curStr) {
//        List<String> list = hashMap.getOrDefault(key, new ArrayList<>());
//        list.add(curStr);
//        hashMap.put(key, list);
//    }
}
