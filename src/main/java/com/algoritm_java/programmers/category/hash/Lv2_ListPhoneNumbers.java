package com.algoritm_java.programmers.category.hash;

import java.util.HashMap;
import java.util.Map;

public class Lv2_ListPhoneNumbers {
    public static boolean solution(String[] phone_book) {
        /**
         * phone_book loop
         *  요소를 기준으로 phone_book 한 번 더 loop
         *  - 요소를 포함하는 문자열이 2개 이상이면 false
         */
//        HashMap<String, Integer> hashMap = new HashMap();
//        for (int i = 0; i < phone_book.length; i++) {
//            String str = phone_book[i].substring(0, 2);
//            hashMap.put(str, hashMap.getOrDefault(str, 0) + 1);
//        }
//        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
//            if (entry.getValue() >= 2) {
//                return false;
//            }
//        }

        /**
         * for loop를 통한 해결
         *  - 정렬
         *  - 1번 순회로 앞뒤 요소 비교하여 startsWith한 요소가 있으면 return false
         */
//        Arrays.sort(phone_book);
//        for (int i = 0; i < phone_book.length - 1; i++) {
//            if (phone_book[i + 1].startsWith(phone_book[i])) return false;
//        }
//        return true;

        /**
         * hash를 통한 해결
         * - hashMap 생성
         * - 2중 loop
         *   - phone_book (array)
         *     - phone_number (string)
         *     - 문자열을 잘라 순회하여 hashMap이 해당 값을 key로 갖고 있으면 return false;
         */
        Map<String, Integer> hashMap = new HashMap();

        for (String phone_number : phone_book) {
            hashMap.put(phone_number, 1);
        }

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (hashMap.containsKey(phone_book[i].substring(0, j))) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        /**
         */
        String[] phone_book1 = {"119", "97674223", "1195524421"};
        String[] phone_book2 = {"123","456","789"};
        String[] phone_book3 = {"12","123","1235","567","88"};

        boolean answer1 = solution(phone_book1);
        boolean answer2 = solution(phone_book2);
        boolean answer3 = solution(phone_book3);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
        System.out.println("answer3 = " + answer3);
    }

}
