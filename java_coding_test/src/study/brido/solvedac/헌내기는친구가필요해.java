package study.brido.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 헌내기는친구가필요해 {

    static int[] dRow = {1, 0, -1, 0};
    static int[] dCol = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];
        int[] start = new int[2];

        for (int i = 0; i < N; i++) {
            String line = new StringTokenizer(br.readLine()).nextToken();
            for (int j = 0; j < M; j++) {
                char c = line.toCharArray()[j];
                board[i][j] = c;
                if (c == 'I') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        int answer = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        board[start[0]][start[1]] = 'X';
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < dRow.length; i++) {
                int nextRow = dRow[i] + poll[0];
                int nextCol = dCol[i] + poll[1];

                if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M && board[nextRow][nextCol] != 'X') {
                    if (board[nextRow][nextCol] == 'P') {
                        answer += 1;
                    }
                    queue.add(new int[]{nextRow, nextCol});
                    board[nextRow][nextCol] = 'X';
                }
            }
        }

        if (answer == 0) {
            System.out.println("TT");
        } else {
            System.out.println(answer);
        }
    }
}
