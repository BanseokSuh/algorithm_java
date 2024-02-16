package com.algoritm_java.programmers.category.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class Lv2_GameMapShortestDistance {
    public static void main(String[] args) {

        /**
         * [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]	11
         * [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]]	-1
         */

        int[][] maps1 = {
            {1, 0, 1, 1, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 1, 1, 1},
            {1, 1, 1, 0, 1},
            {0, 0, 0, 0, 1}
        };

        int[][] maps2 = {
            {1, 0, 1, 1, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 1, 1, 1},
            {1, 1, 1, 0, 0},
            {0, 0, 0, 0, 1}
        };

        int answer1 = solution(maps1);
        int answer2 = solution(maps2);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
    }

    public static int solution(int[][] maps) {
        int answer = 0;
        /**
         * 1. 도착할 수 없을 때는 -1 반환
         * 2. 최단거리는 bfs로 구현
         * 3. 방문한 곳은 0으로 초기화
         * 4. 방문한 곳은 다시 방문하지 않도록
         * 5. 방문한 곳은 큐에 넣지 않도록
         * 6. 큐가 비면 -1 반환
         *
         *
         */
        int n = maps.length;
        int m = maps[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] dist = new int[n][m];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        dist[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int[] dir : dirs) {
                int nx = curr[0] + dir[0];
                int ny = curr[1] + dir[1];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] == 1 && dist[nx][ny] == 0) {
                    dist[nx][ny] = dist[curr[0]][curr[1]] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        return (dist[n - 1][m - 1] == 0) ? -1 : dist[n - 1][m - 1];
    }
}
