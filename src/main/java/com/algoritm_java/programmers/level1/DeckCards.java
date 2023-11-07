package com.algoritm_java.programmers.level1;

public class DeckCards {
    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        int cards1Idx = 0;
        int cards2Idx = 0;

        for (int i = 0; i < goal.length; i++) {
            if (cards1Idx < cards1.length && goal[i].equals(cards1[cards1Idx])) {
                cards1Idx++;
            } else if (cards2Idx < cards2.length && goal[i].equals(cards2[cards2Idx])) {
                cards2Idx++;
            } else {
                return "No";
            }
        }
        return "Yes";
    }

    public static void main(String[] args) {
        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        String[] cards1_1 = {"i", "water", "drink"};
        String[] cards2_1 = {"want", "to"};
        String[] goal_1 = {"i", "want", "to", "drink", "water"};

        String answer = solution(cards1, cards2, goal);
        String answer1 = solution(cards1_1, cards2_1, goal_1);

        System.out.println("answer = " + answer);
        System.out.println("answer1 = " + answer1);
    }
}
