package com.algoritm_java.programmers.category.fullsearch;

import java.util.ArrayList;
import java.util.List;

public class Lv2_VowelDictionary {
    static String[] vowels = {"A", "E", "I", "O", "U"};
    static List<String> list;

    public static void dfs(String cur, int len) {
        list.add(cur);

        if (len == 5) {
            return;
        }

        for (String vowel : vowels) {
            dfs(cur + vowel, len + 1);
        }
    }

    public static int solution(String word) {
        int count = 0;
        list = new ArrayList<>();

        /**
         * 사전: 모든 순열
         *  - 모든 순열 만들면서 word와 같은 문자열 나오면 return count;
         *  - dfs
         */
        dfs("", 0);

        for (int i = 0; i < list.size(); i++) {
            if (word.equals(list.get(i))) {
                count = i;
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String word1 = "AAAAE";
        String word2 = "AAAE";
        String word3 = "I";
        String word4 = "EIO";


        int answer1 = solution(word1);
        int answer2 = solution(word2);
        int answer3 = solution(word3);
        int answer4 = solution(word4);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
        System.out.println("answer3 = " + answer3);
        System.out.println("answer4 = " + answer4);
    }
}
