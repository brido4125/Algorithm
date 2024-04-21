package etc.inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로의최단거리통로 {


    static int[][] board, distance;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public void BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        board[x][y] = 1;
        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];
                if (nx > 0 && nx < 8 && ny > 0 && ny < 8 && board[nx][ny] == 0) {
                    distance[nx][ny] = distance[x][y] + 1;
                    board[nx][ny] = 1;
                    queue.offer(new Point(nx, ny));
                }
            }
        }

    }

    public static void main(String[] args) {
        미로의최단거리통로 T = new 미로의최단거리통로();
        Scanner sc = new Scanner(System.in);

        board = new int[8][8];
        distance = new int[8][8];

        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < 8; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        T.BFS(1, 1);
        if (distance[7][7] == 0) {
            return;
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
