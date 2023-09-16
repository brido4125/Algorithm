package inflearn;

import java.util.Scanner;

public class 미로탐색 {
    static int[][] board;
    static int answer;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};


    public void DFS(int x, int y) {
        if (x == 7 && y == 7) {
            answer++;
            return;
        }
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 1 && nx < 8 && ny >= 1 && ny < 8 && board[nx][ny] == 0) {
                board[nx][ny] = 1;
                DFS(nx, ny);
                board[nx][ny] = 0;
            }
        }
    }

    public static void main(String[] args) {
        미로탐색 m = new 미로탐색();
        Scanner sc = new Scanner(System.in);
        board = new int[8][8];
        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < 8; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        board[1][1] = 1; //첫번째 시작은 1로 고정
        m.DFS(1, 1);
        System.out.println("answer = " + answer);
    }
}
