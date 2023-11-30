package com.algoritm_java.programmers.category.stackandqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lv1_IHateSameNumber {
    public static int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();

        list.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (!list.get(list.size() - 1).equals(arr[i])) {
                list.add(arr[i]);
            }
        }

        return list.stream()
                .mapToInt(i -> (int) i)
                .toArray();
    }

    public static void main(String[] args) {
        int[] arr1 = {1,1,3,3,0,1,1};
        int[] arr2 = {4,4,4,3,3};

        int[] answer1 = solution(arr1);
        int[] answer2 = solution(arr2);

        System.out.println("answer1 = " + Arrays.toString(answer1));
        System.out.println("answer2 = " + Arrays.toString(answer2));
    }
}
