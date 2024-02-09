package com.algoritm_java.programmers.category.dfsbfs;

import java.util.Arrays;

public class Lv2_WordConversion {
    public static void main(String[] args) {
        String begin1 = "hit";
        String target1 = "cog";
        String[] words1 = {"hot", "dot", "dog", "lot", "log", "cog"};

        String begin2 = "hit";
        String target2 = "cog";
        String[] words2 = {"hot", "dot", "dog", "lot", "log"};

        int answer1 = solution(begin1, target1, words1);
        int answer2 = solution(begin2, target2, words2);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
    }

    /**
     * 두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.
     * @param begin
     * @param target
     * @param words
     * @return
     */
    static int answer = 0;

    public static int solution(String begin, String target, String[] words) {

        boolean[] visited = new boolean[words.length];

        dfs(begin, target, words, visited, 0);

        return answer;
    }

    public static void dfs(String begin, String target, String[] words, boolean[] visited, int count) {
        /**
         * 반환 조건
         */
        if (!Arrays.asList(words).contains(target)) {
            return;
        }

        if (begin.equals(target)) {
            answer = count;
            return;
        }

        /**
         * 메인 로직
         */
        for (int i = 0; i < words.length; i++) {
            int diff = 0;

            for (int j = 0; j < words[i].length(); j++) {
                if (begin.charAt(j) != words[i].charAt(j)) {
                    diff++;
                }
            }

            if (diff == 1 && !visited[i]) {
                visited[i] = true;
                dfs(words[i], target, words, visited, count + 1);
                visited[i] = false;
            }
        }
    }
}
