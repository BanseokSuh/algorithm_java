package com.algoritm_java.programmers.category.dfsbfs;

public class Lv3_Network {
    public static void main(String[] args) {

        /**
         * 3 [[1, 1, 0], [1, 1, 0], [0, 0, 1]] 2
         * 3 [[1, 1, 0], [1, 1, 1], [0, 1, 1]] 1
         */

        int n1 = 3;
        int[][] computers1 = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };

        int n2 = 3;
        int[][] computers2 = {
            {1, 1, 0},
            {1, 1, 1},
            {0, 1, 1}
        };

        int answer1 = solution(n1, computers1);
        int answer2 = solution(n2, computers2);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(computers, visited, i); // 연결 정보, 방문 여부, 현재 컴퓨터 번호
                answer++;
            }
        }

        return answer;
    }

    public static void dfs(int[][] computers, boolean[] visited, int i) {
        visited[i] = true;

        for (int j = 0; j < computers.length; j++) {
            if (
                i != j
                && computers[i][j] == 1
                && !visited[j]
            ) {
                dfs(computers, visited, j);
            }
        }
    }
}
