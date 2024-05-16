package com.algoritm_java.hackerrank.problemsolving.warmup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagonalDifference {
    public static void main(String[] args) {

        List<List<Integer>> arr = new ArrayList<>() {{
            add(new ArrayList<>(Arrays.asList(1, 2, 3)));
            add(new ArrayList<>(Arrays.asList(4, 5, 6)));
            add(new ArrayList<>(Arrays.asList(9, 8, 9)));
        }};

        int answer1 = solution(arr);
//        int answer2 = solution(2);
//        int answer3 = solution(2);

        System.out.println("answer1 = " + answer1);
//        System.out.println("answer2 = " + answer2);
//        System.out.println("answer3 = " + answer3);
    }

    public static int solution(List<List<Integer>> arr) {
        int leftSum = 0;
        int rightSum = 0;
        int N = arr.size();

        for (int i = 0; i < N; i++) {
            leftSum += arr.get(i).get(i);
            rightSum += arr.get(i).get(N - 1 - i);
        }

        return Math.abs(rightSum - leftSum);
    }
}
