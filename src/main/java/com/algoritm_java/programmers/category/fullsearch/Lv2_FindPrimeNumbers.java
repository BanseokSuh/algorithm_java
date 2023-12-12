package com.algoritm_java.programmers.category.fullsearch;

import java.util.HashSet;
import java.util.Iterator;

/**
 * [1] 재귀
 * [2] Iterator
 * [3] 에라토스테네스의 체
 */
public class Lv2_FindPrimeNumbers {
    /**
     * hashSet
     */
    HashSet<Integer> numberSet = new HashSet<>();

    void recursive(String comb, String others) {
        // 현재 조합을 set에 추가
        if (!comb.equals("")) {
            numberSet.add(Integer.valueOf(comb));
        }

        // 남은 숫자 중 한 개를 더해서 새로운 조합 생성
        for (int i = 0; i < others.length(); i++) {
            recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
        }
    }

    /**
     * 소수인지 판별
     * @param num
     * @return
     */
    public boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        int limit = (int) Math.sqrt(num);

        for (int i = 2; i <= limit; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public int solution(String numbers) {
        int answer = 0;

        // 재귀
        recursive("", numbers);

        System.out.println("numberSet = " + numberSet);

        // Iterator
        Iterator<Integer> it = numberSet.iterator();

        while (it.hasNext()) {
            int number = it.next();

            // 소수인지 판별 (에라토스테네스의 체)
            if (isPrime(number)) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Lv2_FindPrimeNumbers instance = new Lv2_FindPrimeNumbers();

//        String numbers1 = "17";
        String numbers2 = "011";

//        int answer1 = instance.solution(numbers1);
        int answer2 = instance.solution(numbers2);

//        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
    }
}
