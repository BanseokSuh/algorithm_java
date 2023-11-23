package com.algoritm_java.programmers.level.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DesktopCleanup {
    public static int[] solution(String[] wallpaper) {
        /**
         * int[] answer = {};
         * return answer;
         */
        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();

        // 1차원 배열을 2차원 배열로 변환
        char[][] arr = new char[wallpaper.length][wallpaper[0].length()];
        for (int i = 0; i < wallpaper.length; i++) {
            arr[i] = wallpaper[i].toCharArray();
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == '#') {
                    yList.add(i);
                    xList.add(j);
                }
            }
        }

        int minX = Collections.min(xList);
        int minY = Collections.min(yList);
        int maxX = Collections.max(xList);
        int maxY = Collections.max(yList);

        return new int[]{minY, minX, maxY + 1, maxX + 1};
    }

    public static void main(String[] args) {
        String[] wallpaper = {".#...", "..#..", "...#."};
        String[] wallpaper2 = {"..........", ".....#....", "......##..", "...##.....", "....#....."};

        int[] answer = solution(wallpaper);
        int[] answer2 = solution(wallpaper2);

        System.out.println("answer = " + Arrays.toString(answer));
        System.out.println("answer2 = " + Arrays.toString(answer2));
    }
}
