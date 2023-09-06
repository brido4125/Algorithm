package programmers;

import java.util.*;

public class 하노이의탑 {
    static List<int[]> arrList = new ArrayList<>();

    public int[][] solution(int n) {

        hanoi(n, 1, 3, 2);
        int[][] answer = new int[arrList.size()][2];
        for (int i = 0; i < answer.length; i++){
            answer[i] = arrList.get(i);
        }
        return answer;
    }

    private static void hanoi(int n, int start, int to, int mid) {
        if (n == 1) {
            int[] arr = {start, to};
            arrList.add(arr);
            return;
        }
        hanoi(n - 1, start, mid, to);
        int[] arr = {start, to};
        arrList.add(arr);
        hanoi(n - 1, mid, to, start);
    }
}
