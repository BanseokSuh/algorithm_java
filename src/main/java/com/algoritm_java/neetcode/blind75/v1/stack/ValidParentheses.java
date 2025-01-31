package com.algoritm_java.neetcode.blind75.v1.stack;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s1 = "(("; // []
        String s2 = "([{}])";
        String s3 = "[(])";

        boolean answer1 = mySolution(s1);
        boolean answer2 = mySolution(s2);
        boolean answer3 = mySolution(s3);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
        System.out.println("answer3 = " + answer3);
    }

    /**
     * 문제 접근
     * 핵심 알고리즘 - stack
     * 시간복잡도
     * 다른 방식
     */
    public static boolean mySolution(String s) {
        /**
         * s 문자열 loop
         * 하니씩 꺼내서
         *
         * 현재 요소가 openBracket에 포함되어 있다면 stack에 쌓아
         * 현재 요소가 closeBracket에 포함되어 있다면 stack에서 하나 꺼내서 비교 같으면 continue 다르면 return true;
         */
        if (s.length() < 2) return false;

        String openBracket = "[{(";
        String closeBracket = "]})";

        Stack<Character> stack = new Stack<>(){};

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if (openBracket.indexOf(cur) != -1) {
                stack.add(cur);
                continue;
            }

            if (stack.empty()) return false;

            int curIndex = closeBracket.indexOf(cur);
            int lastCharIdx = openBracket.indexOf(stack.pop());
            if (curIndex != lastCharIdx) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static boolean refSolution(int a) {
        return true;
    }
}
