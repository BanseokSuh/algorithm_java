package com.algoritm_java.programmers.category.hash;

import java.util.HashMap;

public class Lv2_Costumes {
    public static int solution(String[][] clothes) {
        /**
         * hashMap 생성
         * - key: 옷의 종류
         * - value: 종류별 옷의 수
         */
        int answer = 1; // 곱셈 누적을 위해 1로 설정

        HashMap<String, Integer> hm = new HashMap();

        for (int i = 0; i < clothes.length; i++) {
            String type = clothes[i][1];

            hm.put(type, hm.getOrDefault(type, 0) + 1);
        }

        for(String key : hm.keySet()) {
            answer *= (hm.get(key) + 1); // 옷을 안 입는 경우를 위해 +1
        }

        return answer - 1; // 모두 안 입는 경우를 위해 -1 (옷을 안 입는 경우는 없음)
    }

    public static void main(String[] args) {
        String[][] clothes1 = {
            {"yellow_hat", "headgear"},
            {"blue_sunglasses", "eyewear"},
            {"green_turban", "headgear"}
        };

        String[][] clothes2 = {
                {"crow_mask", "face"},
                {"blue_sunglasses", "face"},
                {"smoky_makeup", "face"}
        };

        int answer1 = solution(clothes1);
        int answer2 = solution(clothes2);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
    }
}
