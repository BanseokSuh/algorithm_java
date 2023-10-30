package com.algoritm_java.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TheClosestSameLetter {
    public static int[] solution(String s) {
       String[] stringArray = s.split("");

        List<String> tmpStrList = new ArrayList<>(s.length());
        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < stringArray.length; i++) {
            String str = stringArray[i];

            int lastIdx = tmpStrList.lastIndexOf(str);

            if (lastIdx == -1) {
                resultList.add(-1);
            } else {
                resultList.add(i - lastIdx);
            }

            tmpStrList.add(str);
        }

        return resultList.stream()
                .mapToInt(i -> i)
                .toArray();
    }


    public static void main(String[] arg) {
        int[] result = solution("banana");

        System.out.println("result = " + Arrays.toString(result));
    }
}
