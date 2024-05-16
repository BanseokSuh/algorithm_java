package com.algoritm_java.hackerrank.problemsolving.implementation.easy;

public class DrawingBook {
    public static void main(String[] args) {
        int n1 = 5, p1 = 3;
        int n2 = 6, p2 = 2;
        int n3 = 5, p3 = 4;


        int answer1 = solution(n1, p1);
        int answer2 = solution(n2, p2);
        int answer3 = solution(n3, p3);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
        System.out.println("answer3 = " + answer3);
    }

    public static int solution(int n, int p) {
        int totPage = (int) (double) (n / 2);
        int targetPage = (int) (double) (p / 2);

        return Math.min(targetPage, totPage - targetPage);
    }
}
