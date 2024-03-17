package com.algoritm_java.leetcode.category.string;

public class MergeAlternatelyString {

    public String mergeAlternately(String word1, String word2) {
        int longer = Math.max(word1.length(), word2.length());

        String result = "";

        for (int i = 0; i < longer; i++) {
            if (i < word1.length()) {
                result += word1.charAt(i);
                System.out.println("result.hashCode() = " + result.hashCode());
            }
            if (i < word2.length()) {
                result += word2.charAt(i);
                System.out.println("result.hashCode() = " + result.hashCode());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "pqr";

        String word3 = "ab";
        String word4 = "pqrs";

        String word5 = "abcd";
        String word6 = "pq";

        MergeAlternatelyString mergeAlternately = new MergeAlternatelyString();

        String result1 = mergeAlternately.mergeAlternately(word1, word2);
        String result2 = mergeAlternately.mergeAlternately(word3, word4);
        String result3 = mergeAlternately.mergeAlternately(word5, word6);

        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
        System.out.println("result3 = " + result3);
    }
}
