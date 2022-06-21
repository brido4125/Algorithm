package sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GrassCut {
    static final int INIT_GRASS = 1;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        long[] answers = new long[testCase];
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 1; i <= testCase; i++) {
            int N = sc.nextInt();
            System.out.println("N = " + N);
            int M = sc.nextInt();
            int days = sc.nextInt();
            int[][] board = new int[N][M];
            for (int j = 0; j < board.length; j++) {
                for (int k = 0; k < board[j].length; k++) {
                    int elem = sc.nextInt();
                    board[j][k] = elem;
                    queue.offer(elem);
                }
            }
            int[] oil = new int[days];
            for (int j = 0; j < oil.length; j++) {
                oil[j] = sc.nextInt();
            }
            for (int j = 0; j < answers.length; j++) {
                answers[j] = solution(N, M, days, board, oil, queue);
            }
            queue.clear();
        }
        sc.close();
        System.out.println(Arrays.toString(answers));
    }

    private static long solution(int N,int M, int days,int[][] board,int[] oil,PriorityQueue<Integer> queue) {
        int countDay = 1;
        long totalGrassCut = 0;
        while (days + 1 != countDay) {
            //(해당일 - 1)이 해당일이 가지는 오일값
            for (int i = 0; i < oil[countDay - 1]; i++) {
                int grassCut = queue.poll() + countDay - 1;
                queue.offer(INIT_GRASS - countDay);
                totalGrassCut += grassCut * countDay;
            }
            countDay++;
        }
        return totalGrassCut;
    }
}
