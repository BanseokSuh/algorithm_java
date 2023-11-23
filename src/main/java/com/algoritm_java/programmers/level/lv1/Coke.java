package com.algoritm_java.programmers.level.lv1;

public class Coke {
    public static int solution(int a, int b, int n) {
        /*
         * a: a개를 주면
         * b: b개를 돌려받고
         * n: 현재 남은 빈 병 수
         * result: 받은 콜라의 합계
         */
        return rcv(a, b, n, 0);
    }

    public static int rcv(int a, int b, int n, int result) {
        /*
         * 남은 빈 병이 줄 수 있는 병 수보다 적으면 최종 리턴
         */
        if (n < a) return result;

        /*
         * a개를 줬을 때 돌려받는 빈 병 수
         */
        int change = (n / a) * b;

        /*
         * 현재 남은 병 수 계산
         * - 현재 빈 병 수에서 건네주고 남은 병 수 + 돌려받은 빈 병 수
         */
        n = (n % a) + change;

        /*
         * 재귀
         * result = 돌려받은 빈 병 수 누적
         */
        return rcv(a, b, n, result + change);
    }

    public static void main(String[] args) {
        int answer = solution(2, 1, 20);
        System.out.println("answer = " + answer);
    }
}
