package com.algoritm_java.programmers.level.lv1;

import java.util.*;

public class TwoPulledMore {
    public static int[] solution(int[] numbers) {
        Set<Integer> set = new TreeSet<>();
        int length = numbers.length;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int sum = numbers[i] + numbers[j];
                set.add(sum);
            }
        }

        int[] answer = set.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    public static void main(String[] args) {
        int[] numbers1 = {2,1,3,4,1};
        int[] numbers2 = {5,0,2,7};

        int[] answer1 = solution(numbers1);
        int[] answer2 = solution(numbers2);

        System.out.println("answer1 = " + Arrays.toString(answer1));
        System.out.println("answer2 = " + Arrays.toString(answer2));
    }
}
