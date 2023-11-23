package com.algoritm_java.programmers.level.lv1;

public class WalkPark {
    public static int[] solution(String[] park, String[] routes) {
        int sx = 0;
        int sy = 0;

        char[][] arr = new char[park.length][park[0].length()];

        for (int i = 0; i < park.length; i++) {
            arr[i] = park[i].toCharArray();

            if (park[i].contains("S")) {
                sy = i;
                sx = park[i].indexOf("S");
            }
        }

        for (String st : routes) {
            String way = st.split(" ")[0];
            int len = Integer.parseInt(st.split(" ")[1]);

            int nx = sx;
            int ny = sy;

            for (int i = 0; i < len; i++) {
                if (way.equals("E")) nx++;
                if (way.equals("W")) nx--;
                if (way.equals("S")) ny++;
                if (way.equals("N")) ny--;

                if (nx >= 0 && ny >= 0 && ny < arr.length && nx < arr[0].length) {
                    if (arr[ny][nx] == 'X') {
                        break;
                    }
                    if (i == len-1) {
                        sx = nx;
                        sy = ny;
                    }
                }
            }
        }

        int[] answer = {sy, sx};
        return answer;
    }


    public static void main(String[] arg) {
//        String[] park = {"SOO","OOO","OOO"};
        String[] park = {"OSO","OOO","OXO","OOO"};
        String[] routes = {"E 2","S 2","W 1"};
        int[] result1 = solution(park, routes);
        System.out.println("result1 = " + result1);
    }
}
