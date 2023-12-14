package com.algoritm_java.programmers.level.lv1;

public class PressKeypad {
    public static String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder(); // StringBuilder로 변경 가능한 문자열 생성

        int left = 10; // 왼손 최초 위치 (편의를 위해 *을 10으로 할당)
        int right = 12; // 오른손 최초 위치 (편의를 위해 #을 12로 할당)

        for (int i = 0; i < numbers.length; i++) {
            // 왼손으로 누를 수 있는 번호일 경우
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer.append("L");
                left = numbers[i];

            // 오른손으로 누를 수 있는 변호일 경우
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answer.append("R");
                right = numbers[i];

            // 가운데 번호일 경우
            } else {
                if (numbers[i] == 0) {
                    numbers[i] = 11; // 편의를 위해 0을 11로 할당
                }

                /**
                 * 현재 번호와 왼손(오른손)과의 거리
                 * (현재 번호 - 왼손 위치) / 3 + (현재 번호 - 왼손 위치) % 3
                 * 세로 1칸이 몫, 오른쪽으로 가는 가로 1칸이 나머지
                 */
                int leftDistance = (Math.abs(numbers[i] - left)) / 3 + (Math.abs(numbers[i] - left)) % 3;
                int rightDistance = (Math.abs(numbers[i] - right)) / 3 + (Math.abs(numbers[i] - right)) % 3;

                if (leftDistance == rightDistance) {
                    if (hand.equals("right")) {
                        answer.append("R");
                        right = numbers[i];
                    } else {
                        answer.append("L");
                        left = numbers[i];
                    }
                } else if (leftDistance > rightDistance) {
                    answer.append("R");
                    right = numbers[i];
                } else {
                    answer.append("L");
                    left = numbers[i];
                }
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        int[] numbers1 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand1 = "right";

        int[] numbers2 = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand2 = "left";

        int[] numbers3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand3 = "right";

        String answer1 = solution(numbers1, hand1);
        String answer2 = solution(numbers2, hand2);
        String answer3 = solution(numbers3, hand3);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
        System.out.println("answer3 = " + answer3);
    }
}
