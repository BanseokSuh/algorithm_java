package com.algoritm_java.programmers.category.fullsearch;

public class Lv2_Fatigue {
    public static int answer;
    public static boolean[] visited;

    public static void recursive(int depth, int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            int min = dungeons[i][0]; // 최소 피로도
            int use = dungeons[i][1]; // 소모 피로도

            if (!visited[i] && k >= min) { // 방문하지 않았고 현재 피로도가 최소 피로도 이상일 경우
                int cur = k - use; // 현재 피로도 갱신
                visited[i] = true; // 방문 처리
                recursive(depth+1, cur, dungeons); // 재귀
                visited[i] = false; // 방문 해제 처리
            }
        }
        answer = Math.max(answer, depth);
    }

    public static int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length]; // 방문한 던전 배열

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
