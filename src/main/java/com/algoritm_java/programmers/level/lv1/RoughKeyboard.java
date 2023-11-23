package com.algoritm_java.programmers.level.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RoughKeyboard {
    public static int[] solution(String[] keymap, String[] targets) {
        /**
         * String[] keymap : 키보드 배열
         * String[] targets: 작성해야 하는 단어 배열
         *
         * targets 이중 loop
         *   1) 단어
         *     2) 알파벳
         *
         *     keymap loop - 해당 알파벳의 firstIndex 찾아서 더 작은 것 찾아서 +1
         *     없으면 모든 loop 종료하고 -1 리턴
         */
        int[] answer = new int[targets.length];

        // 단어
        for (int i = 0; i < targets.length; i++) {
            List<Integer> tmpCntList = new ArrayList<>();

            // 알파벳
            for (int j = 0; j < targets[i].length(); j++) {
                char letter = targets[i].charAt(j);
                List<Integer> tmpList = new ArrayList<>();

                // 자판
                for (String key : keymap) {
                    int touchCount = key.indexOf(letter) + 1;
                    if (touchCount > 0) {
                        tmpList.add(touchCount);
                    }
                }

                if (tmpList.size() == 0) {
                    tmpCntList.add(-1);
                } else {
                    tmpCntList.add(Collections.min(tmpList));
                }
            }

            if (tmpCntList.contains(-1)) {
                answer[i] = -1;
            } else {
                answer[i] = tmpCntList.stream().mapToInt(Integer::intValue).sum();
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] keymap1 = {"ABACD", "BCEFD"};
        String[] targets1 = {"ABCD","AABB"};
        String[] keymap2 = {"AA"};
        String[] targets2 = {"B"};
        String[] keymap3 = {"AGZ", "BSSS"};
        String[] targets3 = {"ASA","BGZ"};

        /**
         * ["ABACD", "BCEFD"]	["ABCD","AABB"]	[9, 4]
         * ["AA"]	["B"]	[-1]
         * ["AGZ", "BSSS"]	["ASA","BGZ"]	[4, 6]
         */
        int[] answer1 = solution(keymap1, targets1);
        int[] answer2 = solution(keymap2, targets2);
        int[] answer3 = solution(keymap3, targets3);

        System.out.println("answer1 = " + Arrays.toString(answer1));
        System.out.println("answer2 = " + Arrays.toString(answer2));
        System.out.println("answer3 = " + Arrays.toString(answer3));
    }
}
