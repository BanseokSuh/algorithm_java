package com.algoritm_java.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MemoryScore {
    public static int[] solution1(String[] name, int[] yearning, String[][] photo) {
        /*
         * 1) HashMap으로 {인물: 그리움} map 생성
         * 2) photo 순회하며 map 참조하여 그리움 값 누적
         */
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

        int[] result = new int[photo.length];

        for (int i = 0; i < name.length; i++) {
            hashMap.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            int sum = 0;
            for (int j = 0; j < photo[i].length; j++) {
                if (hashMap.containsKey(photo[i][j])) {
                    sum += hashMap.get(photo[i][j]);
                }
            }
            result[i] += sum;
        }

        return result;
    }
    public static void main(String[] arg) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

        int[] result = solution1(name, yearning, photo);

        for (int j : result) {
            System.out.println("result :: " + j);
        }
    }
}
