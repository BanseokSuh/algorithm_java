package com.algoritm_java.neetcode.blind75.v1.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutDuplicates {
    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "xxxx";
        String s3 = "pwwkew";

        int answer1 = mySolution(s1);
        int answer2 = mySolution(s2);
        int answer3 = mySolution(s3);
        int refAnswer1 = refSolution(s1);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
        System.out.println("answer3 = " + answer3);
        System.out.println("refAnswer1 = " + refAnswer1);
    }

    /**
     * 문제 접근
     * 핵심 알고리즘
     * 시간복잡도
     * 다른 방식
     */
    public static int mySolution(String s) {
        /*
         * Given a string s, find the length of the longest substring without duplicate characters.
         * A substring is a contiguous sequence of characters within a string.
         */
        int sLength = s.length();

        if (sLength == 1) return 1;

        int leftIdx = 0;
        int rightIdx = 1;
        int longest = 0;

        while (rightIdx <= sLength - 1) {
            String curStr = s.substring(leftIdx, rightIdx);

            longest = Math.max(longest, curStr.length());

            String nextChar = String.valueOf(s.charAt(rightIdx));

            int duplicatedCharIdx = curStr.indexOf(nextChar);
            if (duplicatedCharIdx != -1) {
                leftIdx += duplicatedCharIdx + 1;
            }

            rightIdx++;
        }

        return longest;
    }

    public static int refSolution(String s) {
        Set<Character> charSet = new HashSet<>();
        int lIdx = 0;
        int result = 0;

        // 문자열 s만큼 loop 돌며
        for (int rIdx = 0; rIdx < s.length(); rIdx++) {
            // 오른쪽 char 추출
            char rChar = s.charAt(rIdx);
            // 초기 선언한 set에 오른쪽 char 있을 때까지 loop
            while (charSet.contains(rChar)) {
                // set에서 오른쪽 char 발견하는대로 제거 후 leftIdx 1씩 증가
                charSet.remove(s.charAt(lIdx));
                lIdx += 1;
            }
            // 기존 set에 오른쪽 char 모두 제거되었다면 set에 해당 char 추가
            charSet.add(rChar);
            // 결과 객체에 기존 result와 charSet 중 큰 수 할당
            result = Math.max(result, charSet.size());
        }

        return result;
    }

}
