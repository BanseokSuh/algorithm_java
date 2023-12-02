package com.algoritm_java.programmers.category.stackandqueue;

import java.util.*;

public class Lv2_CorrectParentheses {
    public static boolean solution(String s) {
        /**
         * 1. stack 생성
         * 2. while문 - stack이 빌 때까지
         *   - 순회하면서 하나씩 stack의 마지막 요소와 비교
         *   - 짝이 맞으면 stack에서 꺼내기
         *   - 짝이 안 맞으면 stack에 입력
         */
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if (cur == ')') {
                if (stack.isEmpty()) return false;

                if (stack.peek() == '(') {
                    stack.pop();
                }
            } else {
                stack.add(cur);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "()()"; // t
        String s2 = "(())()"; // t
        String s3 = ")()("; // f
        String s4 = "(()("; // f

        boolean answer1 = solution(s1);
        boolean answer2 = solution(s2);
        boolean answer3 = solution(s3);
        boolean answer4 = solution(s4);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
        System.out.println("answer3 = " + answer3);
        System.out.println("answer4 = " + answer4);
    }
}
