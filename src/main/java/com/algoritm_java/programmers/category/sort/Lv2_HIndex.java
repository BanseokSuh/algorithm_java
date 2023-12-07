package com.algoritm_java.programmers.category.sort;

import java.util.Arrays;

public class Lv2_HIndex {
    public static int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;

            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] citations1 = {3, 0, 6, 1, 5};

        int answer1 = solution(citations1);

        System.out.println("answer1 = " + answer1);
    }
}
