package com.algoritm_java.programmers.level1;


import java.util.Arrays;

public class FruitSeller {
    public static int solution(int k, int m, int[] score) {
        /**
         * score
         *   오름차순 정렬
         *   뒤에서부터 자르기
         */
//        int answer = 0;
//
//        Integer[] scoreArr = Arrays.stream(score).boxed().toArray(Integer[]::new);
//        Arrays.sort(scoreArr, Collections.reverseOrder());
//
//        for (int i = 0; i < scoreArr.length; i++) {
//            if ((i + 1) % m == 0) {
//                answer += scoreArr[i] * m;
//            }
//        }
//
//        return answer;
        int answer = 0;

        Arrays.sort(score);

        for (int i = score.length - 1; i >= 0; i--) {
            if ((score.length - i) % m == 0) { // 1번째 요소부터 진행
                answer += score[i] * m;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        /**
         * 3	4	[1, 2, 3, 1, 2, 3, 1]	8
         * 4	3	[4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2]	33
         */
        int k1 = 3;
        int m1 = 4;
        int[] score1 = {1, 2, 3, 1, 2, 3, 1};

        int k2 = 4;
        int m2 = 3;
        int[] score2 = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};

        int answer1 = solution(k1, m1, score1);
        int answer2 = solution(k2, m2, score2);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
    }
}
