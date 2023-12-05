package com.algoritm_java.programmers.category.sort;

import java.util.Arrays;

public class Lv1_KthNumber {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int startIdx = commands[i][0];
            int endIdx = commands[i][1];
            int location = commands[i][2];

            int[] copyArr = Arrays.copyOfRange(array, startIdx - 1, endIdx);

            Arrays.sort(copyArr);

            answer[i] = copyArr[location - 1];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
            { 2, 5, 3 },
            { 4, 4, 1 },
            { 1, 7, 3 }
        };

        int[] answer1 = solution(array, commands);

        System.out.println("answer1 = " + Arrays.toString(answer1));
    }
}
