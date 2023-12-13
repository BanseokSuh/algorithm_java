package com.algoritm_java.programmers.category.fullsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lv2_Carpet {
    public static int[] solution(int brown, int yellow) {
        /**
         * [1] yellow의 약수 구하기
         * [2]
         *   가로 : 약수
         *   세로 : yellow / 약수
         * [3]
         *   if ((가로 * 2) + (세로 * 2) + 4) == brown
         *     return [가로, 세로]
         */
        int[] answer = new int[2];
        List<Integer> list = new ArrayList<>();
        double sqrt = Math.sqrt(yellow);

        for (int i = 1; i <= sqrt; i++) {
            if (yellow % i == 0) {
                if (Math.pow(i, 2) == yellow) {
                    list.add(i); // 본인을 곱했을 경우에 yellow라면. ex) 16에서 4라면
                } else {
                    list.add(i);
                    list.add(yellow / i);
                }
            }
        }

        list.sort(Collections.reverseOrder());

        for (int width : list) {
            int height = yellow / width;

            if ((width * 2) + (height * 2) + 4 == brown) {
                answer = new int[]{width+2, height+2};
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int brown1 = 10;
        int yellow1 = 2;

        int brown2 = 8;
        int yellow2 = 1;

        int brown3 = 24;
        int yellow3 = 24;

        int[] answer1 = solution(brown1, yellow1);
        int[] answer2 = solution(brown2, yellow2);
        int[] answer3 = solution(brown3, yellow3);

        System.out.println("answer1 = " + Arrays.toString(answer1));
        System.out.println("answer2 = " + Arrays.toString(answer2));
        System.out.println("answer3 = " + Arrays.toString(answer3));
    }
}
