package com.algoritm_java.programmers.level.lv1;

public class Trio {
    public static int solution(int[] number) {
        int answer = 0;

        for (int i = 0; i < number.length; i++) {
            for (int j = i + 1; j < number.length; j++) {
                for (int n = j + 1; n < number.length; n++) {
                    int sum = number[i] + number[j] + number[n];

                    if (sum == 0) {
                        answer += 1;
                    }
                }
            }
        }

        return answer;
    }


    public static void main(String[] arg) {
        int[] test1 = {-2, 3, 0, 2, -5};
        int[] test2 = {-3, -2, -1, 0, 1, 2, 3};
        int[] test3 = {-1, 1, -1, 1};

        int result1 = solution(test1);
        int result2 = solution(test2);
        int result3 = solution(test3);

        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
        System.out.println("result3 = " + result3);
    }
}
