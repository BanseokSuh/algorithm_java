package com.algoritm_java.leetcode.category.string;

public class MergeAlternately {

    public String mergeAlternately(String word1, String word2) {
        int longer = Math.max(word1.length(), word2.length());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < longer; i++) {
            if (i < word1.length()) {
                sb.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                sb.append(word2.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "pqr";

        String word3 = "ab";
        String word4 = "pqrs";

        String word5 = "abcd";
        String word6 = "pq";

        MergeAlternately mergeAlternately = new MergeAlternately();

        String result1 = mergeAlternately.mergeAlternately(word1, word2);
        String result2 = mergeAlternately.mergeAlternately(word3, word4);
        String result3 = mergeAlternately.mergeAlternately(word5, word6);

        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
        System.out.println("result3 = " + result3);
    }
}
