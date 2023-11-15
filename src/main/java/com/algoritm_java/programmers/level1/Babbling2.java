package com.algoritm_java.programmers.level1;

public class Babbling2 {

    public static int solution(String[] babbling) {
        int answer = 0;

        for (int i = 0; i < babbling.length; i++) {
            if (
                babbling[i].contains("ayaaya")
                || babbling[i].contains("yeye")
                || babbling[i].contains("woowoo")
                || babbling[i].contains("mama")
            ) {
                continue;
            }

            babbling[i] = babbling[i].replace("aya", " ");
            babbling[i] = babbling[i].replace("ye", " ");
            babbling[i] = babbling[i].replace("woo", " ");
            babbling[i] = babbling[i].replace("ma", " ");
            babbling[i] = babbling[i].replace(" ", "");

            if (babbling[i].length()  == 0) answer++;

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
