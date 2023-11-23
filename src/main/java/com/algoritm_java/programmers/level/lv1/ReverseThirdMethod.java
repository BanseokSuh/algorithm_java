package com.algoritm_java.programmers.level.lv1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseThirdMethod {
    public static int solution(int a) {
        // 3진수, 배열로 변환
        String[] arr = Integer.toString(a, 3).split("");
        List<String> list = Arrays.asList(arr);
        Collections.reverse(list);

        // 역순 정렬
        String[] reverseArr = list.toArray(arr);

        // 문자열로 변환
        String str = Arrays
                .stream(reverseArr) // 문자열 배열 전달
                .collect(Collectors.joining());

        // 3진수 문자열을 10진수로 변환하려 반환
        return Integer.parseInt(str, 3);
    }

    public static void main(String[] args) {

        int answer1 = solution(45);
        int answer2 = solution(125);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer1 = " + answer2);
    }
}
