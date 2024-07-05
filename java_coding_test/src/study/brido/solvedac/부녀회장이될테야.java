package study.brido.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부녀회장이될테야 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[][] board = new int[k + 1][n + 1];
            for (int j = 1; j < n + 1; j++) {
                board[0][j] = j;
            }
            for (int j = 1; j <= k; j++) {
                for (int p = 1; p < n + 1; p++) {
                    for (int q = 1; q <= p; q++) {
                        board[j][p] += board[j - 1][q];
                    }
                }
            }
            System.out.println(board[k][n]);
        }
    }
}
