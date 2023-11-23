package com.algoritm_java.programmers.level.lv1;

import java.util.*;
import java.util.stream.Collectors;

public class NumericPairs {
    public static String solution(String X, String Y) {
        /**
         * 1) X, Y map 생성 -> 각 숫자의 횟수를 저장 (key: 숫자, value: 횟수)
         * 2) xMap의 key와 yMap의 key가 공존한다면, 각 map에서 작은 값을 조회 -> 작은 값이 중복되는 값
         * 3) 중복되는 수만큼 list에 담아 add
         * 4) 정렬 및 문자열화
         */
        Map<String, Integer> xMap = new HashMap<>();
        Map<String, Integer> yMap = new HashMap<>();

        List<String> list = new ArrayList<>();

        for (String key : X.split("")) {
            xMap.put(key, xMap.getOrDefault(key, 0) + 1);
        }

        for (String key : Y.split("")) {
            yMap.put(key, yMap.getOrDefault(key, 0) + 1);
        }

        for (String key : xMap.keySet()) {
            if (!yMap.containsKey(key)) continue;

            int length = Math.min(xMap.get(key), yMap.get(key)); // xMap과 yMap에 공통으로 존재하는 두 값 중 작은 값이 중복되는

            for (int i = 0; i < length; i++) {
                list.add(key);
            }
        }

        // 내림차순 정렬 후 문자열로 변환
        String result = list.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.joining());

        if (result.isEmpty()) return "-1";
        if (result.replaceAll("0", "").isEmpty()) return "0";
        return result;
    }

    public static void main(String[] args) {
        String X1 = "100";
        String Y1 = "2345";
        String X2 = "100";
        String Y2 = "203045";
        String X3 = "100";
        String Y3 = "123450";
        String X4 = "12321";
        String Y4 = "42531";
        String X5 = "5525";
        String Y5 = "1255";

        String answer1 = solution(X1, Y1);
        String answer2 = solution(X2, Y2);
        String answer3 = solution(X3, Y3);
        String answer4 = solution(X4, Y4);
        String answer5 = solution(X5, Y5);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
        System.out.println("answer3 = " + answer3);
        System.out.println("answer4 = " + answer4);
        System.out.println("answer5 = " + answer5);
    }
}
