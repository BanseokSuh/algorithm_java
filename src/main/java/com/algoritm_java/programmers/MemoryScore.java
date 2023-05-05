package com.algoritm_java.programmers;

public class MemoryScore {
    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        /**
         * 1) HashMap으로 {인물: 그리움} map 생성
         * 2) photo 순회하며 map 참조하여 그리움 값 누적
         */

        return null;
    }
    public static void main(String[] arg) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

        int[] result = solution(name, yearning, photo);

        System.out.println("result :: " + result.toString());
    }
}
