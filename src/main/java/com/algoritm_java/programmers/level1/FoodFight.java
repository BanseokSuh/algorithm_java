package com.algoritm_java.programmers.level1;

import java.lang.*;
public class FoodFight {
    public static String solution(int[] food) {
        /*
            1) food[]의 1번째 요소부터 순회 돌기
            2) 요소를 2로 나누고 몫(n) 만 취하기
            3) i를 n번 반복한 문자열 누적
            4) 해당 문자열 뒤집기
            5) 정방향 문자열 + 0 + 역방향 문자열 더해서 리턴
        */

        String forwardString = "";

        for (int i = 1; i < food.length; i++) {
            int n = food[i] / 2;

            for (int j = 0; j < n; j++) {
                forwardString += Integer.toString(i);
            }
        }

        StringBuffer stringBuffer = new StringBuffer(forwardString);
        String reverseString = stringBuffer.reverse().toString();

        String answer = forwardString + "0" + reverseString;
        return answer;
    }

    public static void main(String[] args) {
        int[] food= {1, 3, 4, 6};
        String answer = solution(food);
        System.out.println("answer :: " + answer);
    }
}
