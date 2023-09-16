package inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 섬나라아일랜드 {
    static int N;
    static int[][] board;

    static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
    static int[] dy = {0, -1, 0, 1, 1, -1, -1, 1};

    static int answer = 0;


    public void BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        board[x][y] = 0;
        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && board[nx][ny] == 1) {
                    board[nx][ny] = 0;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) {
        섬나라아일랜드 T = new 섬나라아일랜드();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    T.BFS(i, j);
                }
            }
        }
        System.out.println("answer = " + answer);
    }

    private static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
