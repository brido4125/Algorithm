package etc.inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토 {
    static int n, m;
    static int[][] board, distance;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<Point> queue = new LinkedList<>();

    public void BFS() {

        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];
                if (nx > 0 && nx < n && ny > 0 && ny < m && board[nx][ny] == 0) {
                    distance[nx][ny] = distance[poll.x][poll.y] + 1;
                    board[nx][ny] = 1;
                    queue.offer(new Point(nx, ny));
                }
            }
        }

    }
    public static void main(String[] args) {
        토마토 T = new 토마토();
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        board = new int[n][m];
        distance = new int[n][m];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 1) {
                    queue.offer(new Point(i, j));
                }
            }
        }
        T.BFS();
        boolean flag = true;
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    flag = false;
                    break;
                }
            }
        }
        if (flag) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    answer = Math.max(answer, distance[i][j]);
                }
            }
        }
    }

    static private class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
