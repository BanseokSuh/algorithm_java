package com.algoritm_java;

public class Main {
    public static void main(String[] args) {

        int[] food= {1, 3, 4, 6};
        FoodFight foodFight = new FoodFight();
        String answer = foodFight.solution(food);

        System.out.println("answer ::" + answer);
    }
}
