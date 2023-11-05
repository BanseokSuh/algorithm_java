package com.algoritm_java.programmers.level1;

public class ApplyMorePaint {
    public static int solution(int n, int m, int[] section) {
        /**
         * n: 벽의 넓이
         * m: 롤러 길이
         * section: 칠해야하는 구역
         */
        int start = section[0];
        int end = section[0] + (m - 1);
        int answer = 1;

        /**
         * section을 순회하면서 요소가 start와 end 안에 포함되지 않으면 start와 end를 다시 정의하고 answer++
         */
        for (int i = 0; i < section.length; i++) {
            int cur = section[i];

            if (cur < start || cur > end) {
                start = cur;
                end = cur + (m - 1);
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 8;
        int m = 4;
        int[] section = {2, 3, 6};
        int answer = solution(n, m, section);
        System.out.println("answer = " + answer);
    }
}
