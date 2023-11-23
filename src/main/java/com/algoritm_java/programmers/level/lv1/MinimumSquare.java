package com.algoritm_java.programmers.level.lv1;

import java.util.Arrays;

public class MinimumSquare {
    public static int solution(int[][] sizes) {
        int maxHeight = 0;
        int maxWidth = 0;

        for (int[] size : sizes) {
            Arrays.sort(size);

            int height = size[0];
            int width = size[1];

            if (height > maxHeight) maxHeight = height;
            if (width > maxWidth) maxWidth = width;
        }

        return maxWidth * maxHeight;
    }

    public static void main(String[] args) {
        int[][] sizes1 = {
            {60, 50},
            {30, 70},
            {60, 30},
            {80, 40}
        };

        int[][] sizes2 = {
            {10, 8},
            {12, 3},
            {8, 15},
            {14, 7},
            {5, 15},
        };

        int[][] sizes3 = {
            {14, 4},
            {19, 6},
            {6, 16},
            {18, 7},
            {7, 11},
        };

        int answer1 = solution(sizes1);
        int answer2 = solution(sizes2);
        int answer3 = solution(sizes3);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
        System.out.println("answer3 = " + answer3);
    }
}
