package com.algoritm_java.hackerrank.problemsolving.warmup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleArraySum {
    public static void main(String[] args) {
        List<Integer> ar1 = new ArrayList<>(
                Arrays.asList(1, 2, 3)
        );

        int answer1 = solution(ar1);
//        int answer2 = solution(2);
//        int answer3 = solution(2);

        System.out.println("answer1 = " + answer1);
//        System.out.println("answer2 = " + answer2);
//        System.out.println("answer3 = " + answer3);
    }

    public static int solution(List<Integer> ar) {
        return ar.stream().reduce(0, Integer::sum);
    }
}
