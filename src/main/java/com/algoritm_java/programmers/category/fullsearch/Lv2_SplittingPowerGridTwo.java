package com.algoritm_java.programmers.category.fullsearch;

import java.util.ArrayList;
import java.util.Arrays;

public class Lv2_SplittingPowerGridTwo {
    static ArrayList<Integer>[] graph;
    static int min;

    static int dfs(int v, boolean[] visited) {
        visited[v] = true;
        int cnt = 1;

        for (int next : graph[v]) {
            if (!visited[next]) {
                cnt += dfs(next, visited);
            }
        }

        return cnt;
    }

    public static int solution(int n, int[][] wires) {
        /**
         * [1] wires로 그래프 그리기
         * 서로 끊어져있다는 걸 어떻게 알지
         */
        graph = new ArrayList[n + 1];
        min = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            int top1 = wire[0];
            int top2 = wire[1];

            graph[top1].add(top2);
            graph[top2].add(top1);
        }

        System.out.println("graph = " + Arrays.toString(graph));

        /**
         * 하나씩 끊기
         */
        for (int[] wire : wires) {
            int top1 = wire[0];
            int top2 = wire[1];

            boolean[] visited = new boolean[n + 1];

            graph[top1].remove(Integer.valueOf(top2));
            graph[top2].remove(Integer.valueOf(top1));

            int count = dfs(1, visited);

            int diff = Math.abs(count - (n - count));

            min = Math.min(min, diff);

            graph[top1].add(top2);
            graph[top2].add(top1);
        }


        return min;
    }

    public static void main(String[] args) {
        int n1 = 9;
        int[][] wires1 = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};

        int n2 = 4;
        int[][] wires2 = {{1,2},{2,3},{3,4}};

        int n3 = 7;
        int[][] wires3 = {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}};

        int answer1 = solution(n1, wires1);
        int answer2 = solution(n2, wires2);
        int answer3 = solution(n3, wires3);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
        System.out.println("answer3 = " + answer3);
    }
}
