package com.algoritm_java.neetcode.blind75.v1.arraysandhashing;


import java.util.SortedMap;
import java.util.TreeMap;

public class ValidAnagram {
    public static void main(String[] args) {
        String s1 = "racecar";
        String t1 = "carrace";

        String s2 = "jar";
        String t2 = "jam";

        boolean answer1 = solution(s1, t1);
        boolean answer2 = solution(s2, t2);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
    }

    /**
     * 문제 접근
     * 핵심 알고리즘
     * 시간복잡도
     * 다른 방식
     */
    public static boolean solution(String s, String t) {
        /*
            v1
            1. Convert these two strings to char arrays
            2. Sort both arrays
            3. Compare the arrays
         */
//        if (s.length() != t.length()) return false;
//        char[] sArr = s.toCharArray();
//        char[] tArr = t.toCharArray();
//        Arrays.sort(sArr);
//        Arrays.sort(tArr);
//        return new String(sArr).equals(new String(tArr));

        /*
            v2
            1. Declare two sorted maps for the input strings.
            2. Loop to fill with the count of each letter
            3. Compare the two sorted maps
         */
        if (s.length() != t.length()) return false;

        SortedMap<Character, Integer> sSortedMap = new TreeMap<>();
        SortedMap<Character, Integer> tSortedMap = new TreeMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            sSortedMap.put(sChar, sSortedMap.getOrDefault(sChar, 0) + 1);
            tSortedMap.put(tChar, tSortedMap.getOrDefault(tChar, 0) + 1);
        }

        return sSortedMap.equals(tSortedMap);
    }
}
