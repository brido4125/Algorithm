package dfsandbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindMaze2 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] maze;
    public static void main(String[] args) {
        maze = new int[8][8];
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i < maze.length; i++) {
            for (int j = 1; j < maze.length; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        int bfs = BFS(1, 1);
        System.out.println(bfs);
    }

    private static int BFS(int x,int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            if (poll.getX() == 7 && poll.getY() == 7) {
                return maze[poll.getX()][poll.getY()];
            }
            for (int i = 0; i < dx.length; i++) {
                int nextX = poll.getX() + dx[i];
                int nextY = poll.getY() + dy[i];
                if (nextX >= 1 && nextX <= 7 && nextY >= 1 && nextY <= 7 && maze[nextX][nextY] == 0) {
                    maze[nextX][nextY] = maze[poll.getX()][poll.getY()] + 1;
                    queue.offer(new Point(nextX, nextY));
                }
            }
        }
        return -1;
    }
    static class Point{
        private int x;
        private int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
