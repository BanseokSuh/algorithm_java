package com.algoritm_java.programmers.level1;

public class SplitString {
    public static int solution(String s) {
        int resultCnt = 0;

        char x = s.charAt(0); // a
        int xCnt = 0; // 1
        int yCnt = 0; //

        for (int i = 0; i < s.length(); i++) {
            if (xCnt == yCnt) {
                x = s.charAt(i);
                resultCnt++;
            }

            if (x == s.charAt(i)) {
                xCnt++;
            } else {
                yCnt++;
            }
        }

        return resultCnt;
    }

    public static void main(String[] args) {
        SplitString splitString = new SplitString();
        String s1 = "banana";
        String s2 = "abracadabra";
        String s3 = "aaabbaccccabba";

        int answer1 = splitString.solution(s1);
        int answer2 = splitString.solution(s2);
        int answer3 = splitString.solution(s3);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
        System.out.println("answer3 = " + answer3);
    }
}
