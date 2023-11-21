package com.algoritm_java.programmers.level1;

public class YinYang {
    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i] == false) absolutes[i] *= -1;

            answer += absolutes[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] absolutes1 = {4,7,12};
        boolean[] signs1 = {true,false,true};

        int[] absolutes2 = {1,2,3};
        boolean[] signs2 = {false,false,true};

        int answer1 = solution(absolutes1, signs1);
        int answer2 = solution(absolutes2, signs2);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer1 = " + answer2);
    }
}
