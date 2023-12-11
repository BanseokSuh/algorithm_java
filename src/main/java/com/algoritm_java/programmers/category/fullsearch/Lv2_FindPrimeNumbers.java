package com.algoritm_java.programmers.category.fullsearch;

import java.util.ArrayList;
import java.util.List;

public class Lv2_FindPrimeNumbers {
    static List<Integer> list = new ArrayList<>();
    static boolean[] visited = new boolean[7];

    /**
     * dfs
     * @param numbers
     * @param cur
     * @param m
     */
    public static void dfs(String numbers, String cur, int m) {
        if (cur.length() == m) {
            int num = Integer.parseInt(cur);

            if (!list.contains(num)) {
                list.add(num);
            }
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                cur += numbers.charAt(i);
                dfs(numbers, cur, m);
                visited[i] = false;
                cur = cur.substring(0, cur.length() - 1);
            }
        }
    }

    /**
     * 소수인지 판별
     * @param num
     * @return
     */
    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static int solution(String numbers) {
        int answer = 0;

        /**
         * dfs로 순열 구하기
         */
        for (int i = 0; i < numbers.length(); i++) {
            dfs(numbers, "", i+1);
        }

        /**
         * 소수인지 판별하기
         */
        for (int i = 0; i < list.size(); i++) {
            if (isPrime(list.get(i))) {
                answer++;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        String numbers1 = "17";
        String numbers2 = "011";

        int answer1 = solution(numbers1);
        int answer2 = solution(numbers2);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
    }
}
