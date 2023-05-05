package com.algoritm_java.programmers;
public class PasswordOfUs {
    public static String solution(String s, String skip, int index) {
        String answer = "";
        /*
            0) 알파벳 문자열 선언 alphabetStr = "a~z";
            1) s 순회하면서 해당 알파벳으로 alphabetStr의 인덱스 찾는다.
            2) alphabetStr를 순회하는데 찾은 인덱스부터 인덱스 + index 길이만크만 순회한다.
            3) 하나씩 순회하면서 skip에 해당 알파벳이 존재하는 지 확인한다.
            4) 존재한다면 i++하고 그냥 넘어간다.
            5) 제일 마지막 요소에 도착했을 경우 해당 알파벳을 리턴 str에 담는다.
        */

        char[] charArr = s.toCharArray();

        // s의 길이만큼 순회
        for (int i = 0; i < charArr.length; i++) {
            // s의 각 알파벳에 대해서 index만큼 순회
            for (int j = 0; j < index; j++) {
                // 알파벳 + 1 하면 다음 알파벳
                charArr[i]++;

                // 알파벳 - 1 하면 그 전 알파벳
                // 해당 알파벳이 z보다 크다면 알파벳 길이만큼 빼서 a로 초기화
                if (charArr[i] > 'z') {
                    charArr[i] -= 26;
                }

                // 해당 알파벳이 skip에 해당한다면 한 글자 옮기기
                while(skip.contains(String.valueOf(charArr[i]))) {
                    charArr[i]++;
                    // 해당 알파벳이 z보다 크다면 알파벳 길이만큼 빼서 a로 초기화
                    if (charArr[i] > 'z') {
                        charArr[i] -= 26;
                    }
                }
            }
        }
        answer = String.valueOf(charArr);
        return answer;
    }


    public static void main(String[] arg) {
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;

        String result = solution(s, skip, index);
        System.out.println("result :: " + result.toString());
    }
}
