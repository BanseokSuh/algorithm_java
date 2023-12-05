package com.algoritm_java.programmers.category.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class Lv2_BridgeTruck {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int totalWeight = 0;

        Queue<Integer> bridge = new LinkedList<>();

        /**
         * bridge queue 초기화
         */
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        /**
         * 대기 트럭만큼 loop
         */
        for (int truck : truck_weights) {
            /**
             * 대상이 되는 트럭과 다리의 가장 마지막 요소의 무게가 weight를 넘으면
             *  - 왼쪽으로 한 칸씩 이동
             *  - 오른쪽에 0으로 채움
             */
            while ((totalWeight + truck - bridge.peek()) > weight) {
                totalWeight -= bridge.poll();
                bridge.add(0);
                answer++;
            }

            /**
             * 다리에 트럭 담고 ++
             */
            totalWeight -= bridge.poll();
            totalWeight += truck;
            bridge.add(truck);
            answer++;
        }

        /**
         * loop가 끝나는 시점은 다리 제일 끝에 트럭이 있기 때문에, 트럭이 다리를 다 지나올 때까지를 의미하는 bridge_length를 더해서 반환
         */
        return answer + bridge_length;
    }

    public static void main(String[] args) {
        int bridge_length1 = 2;
        int weight1 = 10;
        int[] truck_weights1 = {7, 4, 5, 6};

        int bridge_length2 = 100;
        int weight2 = 100;
        int[] truck_weights2 = {10};

        int bridge_length3 = 100;
        int weight3 = 100;
        int[] truck_weights3 = {10,10,10,10,10,10,10,10,10,10};

        int answer1 = solution(bridge_length1, weight1, truck_weights1);
        int answer2 = solution(bridge_length2, weight2, truck_weights2);
        int answer3 = solution(bridge_length3, weight3, truck_weights3);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
        System.out.println("answer3 = " + answer3);
    }
}
