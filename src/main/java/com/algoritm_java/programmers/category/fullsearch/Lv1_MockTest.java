package com.algoritm_java.programmers.category.fullsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lv1_MockTest {
    public static int[] solution(int[] answers) {
        /**
         * int[] scoreArr = new int[3];
         * int[][] supoArr = {
         *     {1, 2, 3, 4, 5}, // 5
         *     {2, 1, 2, 3, 2, 4, 2, 5}, // 8
         *     {3, 3, 1, 1, 2, 2, 4, 4, 5, 5} // 10
         * };
         *
         * answers loop
         *
         * supoArr[0][0]
         * supoArr[1][0]
         * supoArr[2][0]
         *
         */
        int[] scoreArr = new int[3];
        int[][] supoArr = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < answers.length; i++) {
            int cur = answers[i];

            if (cur == supoArr[0][i % 5]) scoreArr[0]++;
            if (cur == supoArr[1][i % 8]) scoreArr[1]++;
            if (cur == supoArr[2][i % 10]) scoreArr[2]++;
        }
        
        int max = Arrays.stream(scoreArr).max().getAsInt();

        if (scoreArr[0] == max) answerList.add(1);
        if (scoreArr[1] == max) answerList.add(2);
        if (scoreArr[2] == max) answerList.add(3);

        return answerList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        int[] answers1 = {1, 2, 3, 4, 5};
        int[] answers2 = {1, 3, 2, 4, 2};

        int[] answer1 = solution(answers1);
        int[] answer2 = solution(answers2);

        System.out.println("answer1 = " + Arrays.toString(answer1));
        System.out.println("answer2 = " + Arrays.toString(answer2));
    }
}
