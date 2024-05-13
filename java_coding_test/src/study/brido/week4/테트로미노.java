package study.brido.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 테트로미노 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 1번 일자 직사각형
                int sum = board[i][j];
                sum += add(i, j + 1, board);
                sum += add(i, j + 2, board);
                sum += add(i, j + 3, board);
                pq.add(sum);

                sum = board[i][j];
                sum += add(i + 1, j, board);
                sum += add(i + 2, j, board);
                sum += add(i + 3, j, board);
                pq.add(sum);

                sum = board[i][j];
                sum += add(i - 1, j, board);
                sum += add(i - 2, j, board);
                sum += add(i - 3, j, board);
                pq.add(sum);

                sum = board[i][j];
                sum += add(i, j - 1, board);
                sum += add(i, j - 2, board);
                sum += add(i, j - 3, board);
                pq.add(sum);

                // 2번 L자 - 회전
                sum = board[i][j];
                sum += add(i + 1, j, board);
                sum += add(i + 2, j, board);
                sum += add(i + 2, j + 1, board);
                pq.add(sum);

                sum = board[i][j];
                sum += add(i, j + 1, board);
                sum += add(i, j + 2, board);
                sum += add(i - 1, j + 2, board);
                pq.add(sum);

                sum = board[i][j];
                sum += add(i - 1, j, board);
                sum += add(i - 2, j, board);
                sum += add(i - 2, j - 1, board);
                pq.add(sum);

                sum = board[i][j];
                sum += add(i, j - 1, board);
                sum += add(i, j - 2, board);
                sum += add(i + 1, j - 2, board);
                pq.add(sum);


                //2번 - 가로 대칭
                sum = board[i][j];
                sum += add(i + 1, j, board);
                sum += add(i + 2, j, board);
                sum += add(i + 2, j - 1, board);
                pq.add(sum);

                sum = board[i][j];
                sum += add(i, j - 1, board);
                sum += add(i, j - 2, board);
                sum += add(i - 1, j - 2, board);
                pq.add(sum);

                sum = board[i][j];
                sum += add(i - 1, j, board);
                sum += add(i - 2, j, board);
                sum += add(i - 2, j + 1, board);
                pq.add(sum);

                sum = board[i][j];
                sum += add(i, j + 1, board);
                sum += add(i, j + 2, board);
                sum += add(i + 1, j + 2, board);
                pq.add(sum);

                // 2번 세로 대칭
                sum = board[i][j];
                sum += add(i - 1, j, board);
                sum += add(i - 2, j, board);
                sum += add(i - 2, j + 1, board);
                pq.add(sum);

                sum = board[i][j];
                sum += add(i, j + 1, board);
                sum += add(i, j + 2, board);
                sum += add(i + 1, j + 2, board);
                pq.add(sum);

                sum = board[i][j];
                sum += add(i + 1, j, board);
                sum += add(i + 2, j, board);
                sum += add(i + 2, j - 1, board);
                pq.add(sum);

                sum = board[i][j];
                sum += add(i, j - 1, board);
                sum += add(i, j - 2, board);
                sum += add(i - 1, j - 2, board);
                pq.add(sum);

                //3번
                sum = board[i][j];
                sum += add(i + 1, j, board);
                sum += add(i, j + 1, board);
                sum += add(i + 1, j + 1, board);
                pq.add(sum);

                sum = board[i][j];
                sum += add(i - 1, j, board);
                sum += add(i, j + 1, board);
                sum += add(i - 1, j + 1, board);
                pq.add(sum);

                sum = board[i][j];
                sum += add(i - 1, j, board);
                sum += add(i, j - 1, board);
                sum += add(i - 1, j - 1, board);
                pq.add(sum);

                sum = board[i][j];
                sum += add(i + 1, j, board);
                sum += add(i, j - 1, board);
                sum += add(i + 1, j - 1, board);
                pq.add(sum);

                //4번 - 회전
                sum = board[i][j];
                sum += add(i + 1, j, board);
                sum += add(i + 1, j + 1, board);
                sum += add(i + 2, j + 1, board);
                pq.add(sum);

                sum = board[i][j];
                sum += add(i, j + 1, board);
                sum += add(i - 1, j + 1, board);
                sum += add(i - 1, j + 2, board);
                pq.add(sum);

                sum = board[i][j];
                sum += add(i - 1, j, board);
                sum += add(i - 1, j - 1, board);
                sum += add(i - 2, j - 1, board);
                pq.add(sum);

                sum = board[i][j];
                sum += add(i, j - 1, board);
                sum += add(i + 1, j - 1, board);
                sum += add(i + 1, j - 2, board);
                pq.add(sum);

                //4번 - 대칭 가로
                sum = board[i][j];
                sum += add(i + 1, j, board);
                sum += add(i + 1, j - 1, board);
                sum += add(i + 2, j - 1, board);
                pq.add(sum);

                sum = board[i][j];
                sum += add(i, j - 1, board);
                sum += add(i - 1, j - 1, board);
                sum += add(i - 1, j - 2, board);
                pq.add(sum);

                sum = board[i][j];
                sum += add(i - 1, j, board);
                sum += add(i - 1, j + 1, board);
                sum += add(i - 2, j + 1, board);
                pq.add(sum);

                sum = board[i][j];
                sum += add(i, j + 1, board);
                sum += add(i + 1, j + 1, board);
                sum += add(i + 1, j + 2, board);
                pq.add(sum);

                //4번 - 대칭 세로
                sum = board[i][j];
                sum += add(i - 1, j, board);
                sum += add(i - 1, j + 1, board);
                sum += add(i - 2, j + 1, board);
                pq.add(sum);

                sum = board[i][j];
                sum += add(i, j + 1, board);
                sum += add(i + 1, j + 1, board);
                sum += add(i + 1, j + 2, board);
                pq.add(sum);

                sum = board[i][j];
                sum += add(i + 1, j, board);
                sum += add(i + 1, j - 1, board);
                sum += add(i + 2, j - 1, board);
                pq.add(sum);

                sum = board[i][j];
                sum += add(i, j - 1, board);
                sum += add(i - 1, j - 1, board);
                sum += add(i - 1, j - 2, board);
                pq.add(sum);

                //5번
                sum = board[i][j];
                sum += add(i, j + 1, board);
                sum += add(i, j + 2, board);
                sum += add(i + 1, j + 1, board);
                pq.add(sum);

                sum = board[i][j];
                sum += add(i - 1, j, board);
                sum += add(i - 2, j, board);
                sum += add(i - 1, j + 1, board);
                pq.add(sum);

                sum = board[i][j];
                sum += add(i, j - 1, board);
                sum += add(i, j - 2, board);
                sum += add(i - 1, j - 1, board);
                pq.add(sum);

                sum = board[i][j];
                sum += add(i + 1, j, board);
                sum += add(i + 2, j, board);
                sum += add(i + 1, j - 1, board);
                pq.add(sum);

                //5번 대칭 가로
                sum = board[i][j];
                sum += add(i, j - 1, board);
                sum += add(i, j - 2, board);
                sum += add(i + 1, j - 1, board);
                pq.add(sum);

                sum = board[i][j];
                sum += add(i - 1, j, board);
                sum += add(i - 2, j, board);
                sum += add(i - 1, j - 1, board);
                pq.add(sum);

                sum = board[i][j];
                sum += add(i, j + 1, board);
                sum += add(i, j + 2, board);
                sum += add(i - 1, j + 1, board);
                pq.add(sum);

                sum = board[i][j];
                sum += add(i + 1, j, board);
                sum += add(i + 2, j, board);
                sum += add(i + 1, j + 1, board);
                pq.add(sum);

                //5번 대칭 세로
                sum = board[i][j];
                sum += add(i, j + 1, board);
                sum += add(i, j + 2, board);
                sum += add(i - 1, j + 1, board);
                pq.add(sum);

                sum = board[i][j];
                sum += add(i + 1, j, board);
                sum += add(i + 2, j, board);
                sum += add(i + 1, j + 1, board);
                pq.add(sum);

                sum = board[i][j];
                sum += add(i, j - 1, board);
                sum += add(i, j - 2, board);
                sum += add(i + 1, j - 1, board);
                pq.add(sum);

                sum = board[i][j];
                sum += add(i - 1, j, board);
                sum += add(i - 2, j, board);
                sum += add(i - 1, j - 1, board);
                pq.add(sum);

            }
        }
        System.out.println(pq.poll());
    }

    private static int add(int n, int m, int[][] board) {
        if (0 <= n && n < board.length && 0 <= m && m < board[0].length) {
            return board[n][m];
        }
        return 0;
    }


}
