package study.brido.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 쿠키의신체측정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            board[i] = st.nextToken().toCharArray();
        }

        int[]heart = new int[2];

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (board[i][j] == '*' &&
                    board[i + 1][j] == '*' &&
                    board[i - 1][j] == '*' &&
                    board[i][j + 1] == '*' &&
                    board[i][j - 1] == '*') {
                    heart[0] = i;
                    heart[1] = j;
                }
            }
        }

        int waist = 0;
        for (int i = 1; i < N; i++) {
            if (heart[0] + i < N) {
                if (board[heart[0] + i][heart[1]] == '*') {
                    waist += 1;
                }
            }
        }

        int left = 0;
        for (int i = 1; i < N; i++) {
            if (heart[1] - i >= 0) {
                if (board[heart[0]][heart[1] - i] == '*') {
                    left += 1;
                }
            }
        }

        int right = 0;
        for (int i = 1; i < N; i++) {
            if (heart[1] + i < N) {
                if (board[heart[0]][heart[1] + i] == '*') {
                    right += 1;
                }
            }
        }

        int leftLeg = 0;
        for (int i = 1; i < N; i++) {
            if (heart[0] + i < N) {
                if (board[heart[0] + i][heart[1] - 1] == '*') {
                    leftLeg += 1;
                }
            }
        }

        int rightLeg = 0;
        for (int i = 1; i < N; i++) {
            if (heart[0] + i < N) {
                if (board[heart[0] + i][heart[1] + 1] == '*') {
                    rightLeg += 1;
                }
            }
        }

        int[] ansnwer = {left, right, waist, leftLeg, rightLeg};
        System.out.println((heart[0] + 1) + " " + (heart[1] + 1));
        Arrays.stream(ansnwer).forEach(s -> System.out.print(s + " "));

    }
}
