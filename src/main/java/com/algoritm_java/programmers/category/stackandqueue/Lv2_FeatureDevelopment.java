package com.algoritm_java.programmers.category.stackandqueue;

import java.util.*;

public class Lv2_FeatureDevelopment {
    public static int[] solution(int[] progresses, int[] speeds) {
        /**
         * =================================================================================
         * 배열를 사용한 풀이
         */
//        List<Integer> list = new ArrayList<>();
//
//        /**
//         * 일이 끝나는 일수 배열
//         */
//        int[] works = new int[progresses.length];
//
//        for (int i = 0; i < speeds.length; i++) {
//            works[i] = (100 - progresses[i]) / speeds[i];
//
//            if ((100 - progresses[i]) % speeds[i] != 0) {
//                works[i] += 1;
//            }
//        }
//
//        int x = works[0];
//        int count = 1;
//
//        for (int i = 1; i < progresses.length; i++) {
//            if (x >= works[i]) {
//                count += 1;
//            } else {
//                list.add(count);
//                count = 1;
//                x = works[i];
//            }
//        }
//
//        list.add(count);
//
//        /**
//         * list to array 숙지
//         */
//        return list.stream()
//                .mapToInt(i -> (int) i)
//                .toArray();

        /**
         * =================================================================================
         * queue를 활용한 풀이
         */

        /**
         * queue 배열
         * - 각 task마다 걸리는 일 수
         */
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < speeds.length; i++) {
            queue.add((100 - progresses[i]) / speeds[i]);
        }

        /**
         * queue에서 하나씩 빼서 queue가 빌 때까지
         */
        List<Integer> answerList = new ArrayList<>();

        int cur = queue.poll(); // queue에서 꺼내기
        int cnt = 1;

        while (!queue.isEmpty()) {
            if (cur < queue.peek()) { // queue 꺼내서 이전 값이랑 비교. 현재값이 더 작으면 list에 담고 값 초기화
                answerList.add(cnt);
                cur = queue.poll();
                cnt = 1;
            } else {
                cnt++;
                queue.poll(); // queue 제일 앞 요소 제거
            }
        }

        answerList.add(cnt); // queue가 다 비어 list에 add()되지 못하는 경우

        return answerList.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }

    public static void main(String[] args) {
        int[] progresses1 = {93, 30, 55};
        int[] speeds1 = {1, 30, 5};

        int[] progresses2 = {95, 90, 99, 99, 80, 99};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};

        int[] answer1 = solution(progresses1, speeds1);
        int[] answer2 = solution(progresses2, speeds2);

        System.out.println("answer1 = " + Arrays.toString(answer1));
        System.out.println("answer2 = " + Arrays.toString(answer2));
    }
}
