package com.algoritm_java.programmers.category.hash;

import java.util.Arrays;
import java.util.HashMap;

public class PlayersWhoDidNotComplete {
    public static String solution(String[] participant, String[] completion) {
        /**
         * [배열]
         * 두 배열 sort해서 다르면 리턴
         * 중간에 다른 요소 없으면 participant의 제일 마지막 요소 리턴
         */
//        Arrays.sort(participant);
//        Arrays.sort(completion);
//        for (int i = 0; i < completion.length; i++) {
//            if (!participant[i].equals(completion[i])) return participant[i];
//        }
//        return participant[participant.length-1];

        /**
         * [Hash]
         *
         */
        String answer = "";

        HashMap<String, Integer> hm = new HashMap<>();

        for (String player : participant) {
            hm.put(player, hm.getOrDefault(player, 0) + 1);
        }

        for (String player : completion) {
            hm.put(player, hm.get(player) - 1);
        }

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] participant1 = {"leo", "kiki", "eden"};
        String[] completion1 = {"eden", "kiki"};

        String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion2 = {"josipa", "filipa", "marina", "nikola"};

        String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
        String[] completion3 = {"stanko", "ana", "mislav"};

        String answer1 = solution(participant1, completion1);
        String answer2 = solution(participant2, completion2);
        String answer3 = solution(participant3, completion3);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
        System.out.println("answer3 = " + answer3);
    }
}
