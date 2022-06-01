package basicSearch;

import java.util.Scanner;

public class Island {
    static int N;
    //9시 -> 7시반 -> 6시 -> 4시반 -> 3시 ->1시반-> 12시 -> 11시반
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, 1, -1, 0, 1, -1, 1};
    static int sumOfIsland = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(board));

    }


    private static int solution(int[][] board) {
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    board[i][j] = 0;
                    dfs(i, j, board);
                }
            }
        }
        return answer;
    }

    private static void dfs(int x, int y, int[][] board) {
        for (int k = 0; k < dx.length; k++) {
            int nextX = x + dx[k];
            int nextY = y + dy[k];
            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && board[nextX][nextY] == 1) {
                board[nextX][nextY] = 0;
                dfs(nextX, nextY, board);
            }
        }
    }
}

