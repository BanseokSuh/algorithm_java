package com.algoritm_java.programmers.category.dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lv3_TravelRoute {

    static List<String> routeList = new ArrayList<>();
    static boolean[] visited;
    
    public static void main(String[] args) {
        /**
         * [["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]	["ICN", "JFK", "HND", "IAD"]
         * [["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]	["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
         */

        String[][] tickets1 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] tickets2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};

        String[] answer1 = solution(tickets1);
        String[] answer2 = solution(tickets2);

        System.out.println("answer1 = " + Arrays.toString(answer1));
        System.out.println("answer2 = " + Arrays.toString(answer2));
    }


    public static String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];

        dfs("ICN", "ICN", tickets, 0);

        Collections.sort(routeList);

        return routeList.get(0).split(" ");
    }

    public static void dfs(String start, String answer, String[][] tickets, int count) {
        if (count == tickets.length) {
            routeList.add(answer);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(start)) {
                visited[i] = true;
                dfs(tickets[i][1], answer + " " + tickets[i][1], tickets, count + 1);
                visited[i] = false;
            }
        }
    }
}
