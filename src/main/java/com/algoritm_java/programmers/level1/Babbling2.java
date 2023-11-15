package com.algoritm_java.programmers.level1;

public class Babbling2 {

    public static int solution(String[] babbling) {
        /**
         * {"aya", "ye", "woo", "ma"} 말 말할 수 있음
         */
        int answer = 0;

        for (int i = 0; i < babbling.length; i++) {
            String babble = babbling[i];

            if (
                babble.contains("ayaaya") // 연속되는 단어 -> 아예 할 수 없으니 continue
                || babble.contains("yeye")
                || babble.contains("woowoo")
                || babble.contains("mama")
            ) {
                continue;
            }

            // 빈 문자열로 치환
            babble = babble.replace("aya", " ");
            babble = babble.replace("ye", " ");
            babble = babble.replace("woo", " ");
            babble = babble.replace("ma", " ");

            /**
             * 바로 빈 문자열로 하지 않고 공백을 주는 이유
             * - yayae의 경우 가운데 aya가 치환되어 ye가 되고, ye가 치환되어 빈 문자열이 되면
             *   말할 수 없는 단어임에도 말할 수 있다고 결과가 나오기 때문에 이런 경우를 방지
             */
            babble = babble.replace(" ", "");

            // 최종 치환된 문자열의 길이가 0일때
            System.out.println("babble = " + babble);
            if (babble.length() == 0) answer++;

        }
        return answer;
    }

    public static void main(String[] args) {
        String[] babbling1 = {"aya", "yee", "u", "maa"};
        String[] babbling2 = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};

        int answer1 = solution(babbling1);
        int answer2 = solution(babbling2);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
    }



}
