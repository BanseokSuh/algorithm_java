package com.algoritm_java.programmers.category.stackandqueue;

import java.util.LinkedList;

public class Lv2_BridgeTruck {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int totalWeight = 0;

        LinkedList<Integer> bridge = new LinkedList<>();

        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        for (int truck : truck_weights) {
            while ((totalWeight + truck - bridge.peek()) > weight) {
                totalWeight -= bridge.poll();
                bridge.add(0);
                answer++;
            }

            totalWeight -= bridge.poll();
            totalWeight += truck;
            bridge.add(truck);
            answer++;
        }

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
