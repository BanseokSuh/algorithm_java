package com.algoritm_java.hackerrank.problemsolving.warmup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AVeryBigSum {
    public static void main(String[] args) {
        List<Long> ar1 = new ArrayList<>(
                Arrays.asList(1000000001L, 1000000002L, 1000000003L, 1000000004L, 1000000005L)
        );

        long answer1 = solution(ar1);
//        int answer2 = solution(2);
//        int answer3 = solution(2);

        System.out.println("answer1 = " + answer1);
//        System.out.println("answer2 = " + answer2);
//        System.out.println("answer3 = " + answer3);
    }

    public static Long solution(List<Long> ar) {
        return ar.stream().reduce(0L, Long::sum);
    }
}
