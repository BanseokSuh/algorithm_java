package com.algoritm_java.hackerrank.problemsolving.implementation.medium;

import java.lang.reflect.Array;
import java.util.*;

public class ClimbingLeaderboard {
    public static void main(String[] args) {
        List<Integer> ranked1 = new ArrayList<>(
                Arrays.asList(100, 100, 50, 40, 40, 20, 10)
        );

        List<Integer> player1 = new ArrayList<>(
                Arrays.asList(5, 25, 50, 120)
        );

        List<Integer> ranked2 = new ArrayList<>(
                Arrays.asList(100, 70, 60, 50, 40, 30, 20, 10, 5, 3)
        );

        List<Integer> player2 = new ArrayList<>(
                Arrays.asList(80, 75, 65, 25, 7)
        );

//        List<Integer> answer1 = solution(ranked1, player1);
        List<Integer> answer2 = solution(ranked2, player2);
//        int answer3 = solution(2);

//        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
//        System.out.println("answer3 = " + answer3);
    }

    private static int getAddedRank(List<Integer> uniqueRank, int curScore) {
        /*
           Binary search
         */
        int left = 0;
        int right = uniqueRank.size() - 1;
        int addedRank = 0;

        while (left < right) {
            int mid = (left + right) / 2;

            System.out.println("[curScore] left / mid / right = [" + curScore + "] " + left + " / " + mid + " / " + right);

            if (curScore == uniqueRank.get(mid)) {
                addedRank = uniqueRank.get(mid);
                break;
            } else if (curScore < uniqueRank.get(mid)) {
                if (uniqueRank.get(right) > curScore) {
                    addedRank = uniqueRank.size() + 1;
                } else {
                    addedRank = mid + 1;
                }
                left = mid + 1;
            } else {
                addedRank = mid + 1;
                right = mid - 1;
            }
        }

        return addedRank;
    }

    public static List<Integer> solution(List<Integer> ranked, List<Integer> player) {
//        ArrayList<Integer> leaderboard = (ArrayList<Integer>) ranked;
//        ArrayList<Integer> playerScores = (ArrayList<Integer>) player;
//        ArrayList<Integer> ranks = new ArrayList<>();
//        HashMap<Integer, Integer> rankings = new HashMap<>();
//
//        int rank = 1;
//
//        for (int score : leaderboard) {
//            if (!rankings.containsKey(score)) {
//                rankings.put(score, rank++); // ??
//            }
//        }
//
//        int initial = leaderboard.size() - 1;
//        for (int score : playerScores) {
//            for (int i = initial; i >= 0; i--) {
//                if (score >= leaderboard.get(i)) {
//                    rank = rankings.get(score); // ??
//                    initial = i - 1;
//                } else {
//                    break;
//                }
//            }
//            ranks.add(rank);
//        }
//        return ranks;


//        ============================================================================= Binary search
        List<Integer> result = new ArrayList<>();
        List<Integer> uniqueRank = new ArrayList<>();

//         Set unique rank board
        for (int curRank : ranked) {
            if (!uniqueRank.contains(curRank)) {
                uniqueRank.add(curRank);
            }
        }

        System.out.println("uniqueRank = " + uniqueRank);
        System.out.println("player = " + player);

        for (int curScore : player) {
            if (uniqueRank.contains(curScore)) {
                result.add(uniqueRank.indexOf(curScore) + 1);
            } else {
                /*
                   Binary search
                 */
                result.add(getAddedRank(uniqueRank, curScore));
                /*
                    Timeout error
                 */
//                for (int i = 0; i < uniqueRank.size(); i++) {
//                    if (curScore > uniqueRank.get(i)) {
//                        result.add(i + 1);
//                        break;
//                    }
//
//                    if (i == uniqueRank.size() - 1) {
//                        result.add(uniqueRank.size() + 1);
//                        break;
//                    }
//                }
            }
        }
        return result;

//        ============================================================================= Timeout error
//        List<Integer> uniqueRank = new ArrayList<>(new HashSet<>(ranked));
//        uniqueRank.sort(Collections.reverseOrder());
////        SortedSet<Integer> uniqueRankSet = new TreeSet<>(ranked);
//
//        List<Integer> result = new ArrayList<>();
//
//        for (Integer curScore : player) {
//            if (uniqueRank.contains(curScore)) {
//                result.add(uniqueRank.indexOf(curScore) + 1);
//            } else {
//                System.out.println("uniqueRank = " + uniqueRank.size());
//                for (int j = 0; j < uniqueRank.size(); j++) {
//
//                    if (uniqueRank.get(j) < curScore) {
//                        uniqueRank.add(j, curScore);
//                        result.add(j + 1);
//                        break;
//                    } else if (j == uniqueRank.size() - 1) {
//                        uniqueRank.add(curScore);
//                        result.add(uniqueRank.indexOf(curScore) + 1);
//                        break;
//                    }
//                }
//            }
//        }
//
//        return result;
    }
}
