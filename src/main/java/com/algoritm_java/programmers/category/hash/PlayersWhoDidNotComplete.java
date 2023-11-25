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
         * 참가자 순회하여 hashMap에 key-value 형태로 이름-값 데이터 생성
         * 완료자 순회하여 hashMap에서 같은 이름의 value를 1씩 뺌
         * hashMap에서 값이 0이 아닌 key 리턴
         */
        String answer = "";

        /**
         * hashMap 인스턴스 생성
         */
        HashMap<String, Integer> hm = new HashMap<>();

        /**
         * participant 순회
         * key=player, value=1
         * 이름이 중복된 참가자면 += 1
         */
        for (String player : participant) {
            hm.put(player, hm.getOrDefault(player, 0) + 1);
        }

        /**
         * completion 순회
         * hashMap에서 player 조회해서 해당 value -1
         */
        for (String player : completion) {
            hm.put(player, hm.get(player) - 1);
        }

        /**
         *  hashMap을 탐색해서 value가 0이 아닌 key 찾아 리턴
         */
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
