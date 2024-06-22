package com.algoritm_java.hackerrank.problemsolving.implementation.easy;

public class SaveThePrisoner {
    public static void main(String[] args) {
        int n1 = 5, m1 = 2, s1 = 1;
        int n2 = 5, m2 = 2, s2 = 2;
        int n3 = 7, m3 = 19, s3 = 2;
        int n4 = 368127406, m4 = 680428368, s4 = 105517295;
        int n5 = 946486979, m5 = 973168361, s5 = 647886035;
        int n6 = 352926151, m6 = 380324688, s6 = 94730870;

        int answer1 = solution(n1, m1, s1);
        int answer2 = solution(n2, m2, s2);
        int answer3 = solution(n3, m3, s3);
        int answer4 = solution(n4, m4, s4);
        int answer5 = solution(n5, m5, s5);
        int answer6 = solution(n6, m6, s6);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
        System.out.println("answer3 = " + answer3);
        System.out.println("answer4 = " + answer4);
        System.out.println("answer5 = " + answer5);
        System.out.println("answer6 = " + answer6);
    }

    public static int solution(int n, int m, int s) {

        int treated = (m + s - 1) % n;
        return treated > 0 ? treated : n;
//        return (int) (m % n) + s - 1;
    }


}
