package study.brido.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이만들기 {

    static int blue = 0;
    static int white = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[][] board = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        calc(N, board, new int[]{1, 1});

        System.out.println(white);
        System.out.println(blue);
    }

    /*
    * int i = point[0]; i < point[0] 이 아니라
    * int i = point[0]; i < point[0] + N 로 구현해야 늘어난 길이만큼 순회
    * */
    private static void calc(int N, int[][] board, int[] point) {
        int init = board[point[0]][point[1]];
        for (int i = point[0]; i < point[0] + N; i++) {
            for (int j = point[1]; j < point[1] + N; j++) {
                if (init != board[i][j]) {
                    calc(N / 2, board, new int[]{point[0], point[1]});
                    calc(N / 2, board, new int[]{point[0], point[1] + N / 2});
                    calc(N / 2, board, new int[]{point[0] + N / 2, point[1]});
                    calc(N / 2, board, new int[]{point[0] + N / 2, point[1] + N / 2});
                    return;
                }
            }
        }
        if (init == 0) {
            white += 1;
        } else {
            blue += 1;
        }
    }

}
