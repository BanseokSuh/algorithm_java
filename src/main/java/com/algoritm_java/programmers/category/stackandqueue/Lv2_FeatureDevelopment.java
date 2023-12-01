package com.algoritm_java.programmers.category.stackandqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lv2_FeatureDevelopment {
    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();

        /**
         * 일이 끝나는 일수 배열
         */
        int[] works = new int[progresses.length];

        for (int i = 0; i < speeds.length; i++) {
            works[i] = (100 - progresses[i]) / speeds[i];

            if ((100 - progresses[i]) % speeds[i] != 0) {
                works[i] += 1;
            }
        }

        int x = works[0];
        int count = 1;

        for (int i = 1; i < progresses.length; i++) {
            if (x >= works[i]) {
                count += 1;
            } else {
                list.add(count);
                count = 1;
                x = works[i];
            }
        }
        
        list.add(count);

        /**
         * list to array 숙지
         */
        return list.stream()
                .mapToInt(i -> (int) i)
                .toArray();
    }

    public static void main(String[] args) {
        int[] progresses1 = {93, 30, 55};
        int[] speeds1 = {1, 30, 5};

        int[] progresses2 = {95, 90, 99, 99, 80, 99};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};

        int[] answer1 = solution(progresses1, speeds1);
        int[] answer2 = solution(progresses2, speeds2);

        System.out.println("answer1 = " + Arrays.toString(answer1));
        System.out.println("answer2 = " + Arrays.toString(answer2));
    }
}
