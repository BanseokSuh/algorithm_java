package com.algoritm_java.programmers.category.dfsbfs;

public class Lv2_TargetNumber {
    public static void main(String[] args) {
        int[] numbers1 = {1, 1, 1, 1, 1};
        int target1 = 3;

        int[] numbers2 = {4, 1, 2, 1};
        int target2 = 4;

        int answer1 = solution(numbers1, target1);
        int answer2 = solution(numbers2, target2);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
    }


    public static int solution(int[] numbers, int target) {
        int answer = 0;

        answer = dfs(numbers, target, 0, 0);

        return answer;
    }


    /**
     * dfs
     * 재귀함수
     * 1) 구현부를 먼저 작성한다. -> 재귀함수가 어떠한 로직인지 정의한다.
     * 2) 반환 조건을 작성한다. -> 무한 로프를 방지
     *
     * @param numbers
     * @param target
     * @param index
     * @param sum
     * @return
     */
    public static int dfs(int[] numbers, int target, int index, int sum) {
        if (index == numbers.length) {
            return sum == target ? 1 : 0;
        } else {
            // 각 요소를 더하거나 빼는 경우의 수를 모두 구한다.
            int plusSum = dfs(numbers, target, index + 1, sum + numbers[index]);
            int minusSum = dfs(numbers, target, index + 1, sum - numbers[index]);

            return plusSum + minusSum;
        }
    }




    /**
     * note
     * 1 1 1 1 1
     * 1 1 1 1 -1
     * 1 1 1 -1 1
     * 1 1 1 -1 -1
     * 1 1 -1 1 1
     * 1 1 -1 1 -1
     * 1 1 -1 -1 1
     * 1 1 -1 -1 -1
     * 1 -1 1 1 1
     * 1 -1 1 1 -1
     * 1 -1 1 -1 1
     * 1 -1 1 -1 -1
     * 1 -1 -1 1 1
     * 1 -1 -1 1 -1
     * 1 -1 -1 -1 1
     * 1 -1 -1 -1 -1
     *
     * -1 1 1 1 1
     * -1 1 1 1 -1
     * -1 1 1 -1 1
     * -1 1 1 -1 -1
     * -1 1 -1 1 1
     * -1 1 -1 1 -1
     * -1 1 -1 -1 1
     * -1 1 -1 -1 -1
     * -1 -1 1 1 1
     * -1 -1 1 1 -1
     * -1 -1 1 -1 1
     * -1 -1 1 -1 -1
     * -1 -1 -1 1 1
     * -1 -1 -1 1 -1
     * -1 -1 -1 -1 1
     * -1 -1 -1 -1 -1
     */

}
