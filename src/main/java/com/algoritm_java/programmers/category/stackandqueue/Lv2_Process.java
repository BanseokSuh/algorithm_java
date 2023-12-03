package com.algoritm_java.programmers.category.stackandqueue;

import java.util.*;

public class Lv2_Process {
    public static int solution(int[] priorities, int location) {
        /**
         * 1. 실행 대기 큐(Queue)에서 대기중인 프로세스 하나를 꺼냅니다.
         * 2. 큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣습니다.
         * 3. 만약 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행합니다.
         *   3.1 한 번 실행한 프로세스는 다시 큐에 넣지 않고 그대로 종료됩니다.
         *
         */

        /**
         * queue 생성 및 queue 초기화
         */
//        Queue<Integer> queue = new LinkedList<>();
//        for (int num : priorities) queue.add(num);
//        int answer = 0;
//        int count = 0;
//        int myLocation = location;
//        /**
//         * queue에 값이 있을 동안 loop
//         */
//        while (!queue.isEmpty()) {
//            int cur = queue.poll(); // 현재값 뽑기
//            int bigger = getBigger(cur, queue); // 현재값과 queue에서 가장 큰 값 중 더 큰 값
//            if (bigger > cur) { // queue에 더 큰 값이 남아 있다면 -> queue에 현재값 추가
//                queue.add(cur);
//            } else {
//                count++;
//                if (myLocation == 0) {
//                    answer = count;
//                    break;
//                }
//            }
//            myLocation--;
//            if (myLocation == -1) {
//                myLocation = queue.size() - 1;
//            }
//        }
//        return answer;

        /**
         * PriorityQueue 활용
         *
         */
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        /**
         * pq 초기화
         */
        for (int num : priorities) queue.offer(num);

        /**
         * pq가 빌 때까지 loop
         *  - queue에서의 값과 priorities 값 비교
         */
        while (!queue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (queue.peek() == priorities[i]) {
                    queue.poll();
                    answer++;

                    if (location == i) {
                        return answer;
                    }
                }
            }
        }

        return answer;
    }
    /**
     * 현재값과 queue에서 가장 큰 값 중 더 큰 값 리턴
     * @param cur
     * @param queue
     * @return
     */
//    public static int getBigger(int cur, Queue<Integer> queue) {
//        int max = cur;
//        for (int num : queue) {
//            max = Math.max(num, max);
//        }
//        return max;
//    }


    public static void main(String[] args) {
        int[] priorities1 = {2, 1, 3, 2};
        int location1 = 2;

        int[] priorities2 = {1, 1, 9, 1, 1, 1};
        int location2 = 0;

        int answer1 = solution(priorities1, location1);
        int answer2 = solution(priorities2, location2);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
    }
}

