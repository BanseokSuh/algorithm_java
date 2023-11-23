package com.algoritm_java.programmers.level.lv1;

import java.util.ArrayList;
import java.util.List;

public class MakingHamburgers {
    public static int solution(int[] ingredient) {
        /**
         * 1: 빵
         * 2: 야채
         * 3: 고기
         * 4: 빵
         *
         * ingredient에서 하나씩 꺼내서 별도의 stack에 쌓아
         * stack.length가 4 이상이고, 제일 뒤 4 요소가 1,2,3,1일 때 4요소 꺼내고 answer++
         */
        int answer = 0;

        List<Integer> stack = new ArrayList<>();

        for (int i = 0; i < ingredient.length; i++) {
            stack.add(ingredient[i]);

            if (stack.size() >= 4) {
                List<Integer> subList = stack.subList(stack.size() - 4, stack.size());

                if (
                    subList.get(0).equals(1)
                        && subList.get(1).equals(2)
                        && subList.get(2).equals(3)
                        && subList.get(3).equals(1)
                ) {
                    answer++;
                    stack.subList(stack.size() - 4, stack.size()).clear();
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] ingredient1 = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        int[] ingredient2 = {1, 3, 2, 1, 2, 1, 3, 1, 2};

        int answer1 = solution(ingredient1);
        int answer2 = solution(ingredient2);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
    }
}
