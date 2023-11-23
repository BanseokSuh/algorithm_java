package com.algoritm_java.programmers.level.lv1;

import java.util.Arrays;

public class HallFame1 {
    public static int[] solution(int k, int[] score) {
        /**
         * score loop
         */
        int[][] tmpArr = new int[score.length][score.length];
        int[] answerArr = new int[score.length];

        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j <= i; j++) {
                tmpArr[i][j] = score[j];
            }
        }

        for (int i = 0; i < tmpArr.length; i++) {
            Arrays.sort(tmpArr[i]);

            if (i+1 < k) {
                answerArr[i] = tmpArr[i][tmpArr[i].length - 1 - i];
            } else {
                answerArr[i] = tmpArr[i][tmpArr[i].length - k];
            }
        }

        return answerArr;
    }

    public static void main(String[] args) {
        int k1 = 3;
        int[] score1 = {10, 100, 20, 150, 1, 100, 200};

        int k2 = 4;
        int[] score2 = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};

        int[] answer1 = solution(k1, score1);
        int[] answer2 = solution(k2, score2);

        System.out.println("answer1 = " + Arrays.toString(answer1));
        System.out.println("answer2 = " + Arrays.toString(answer2));
    }
}
