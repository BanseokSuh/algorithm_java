package com.algoritm_java.programmers.category.fullsearch;

public class Lv2_Fatigue {
    public static int answer;
    public static boolean[] visited;

    public static void recursive(int depth, int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            int min = dungeons[i][0];
            int use = dungeons[i][1];

            if (!visited[i] && k >= min) {
                int cur = k - use;
                visited[i] = true;
                recursive(depth+1, cur, dungeons);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, depth);
    }

    public static int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];

        recursive(0, k, dungeons);

        return answer;
    }

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {
            {80,20},
            {50,40},
            {30,10}
        };

        int answer1 = solution(k, dungeons);

        System.out.println("answer1 = " + answer1);
    }
}
