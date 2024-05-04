package study.brido.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 로봇청소기 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = 0;
    static int direction;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        direction= Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(new Point(r, c), board);
        System.out.println(answer);

    }

    private static void bfs(Point start, int[][] board) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Point recent = queue.poll();
            if (board[recent.x][recent.y] == 0) {
                answer += 1;
                board[recent.x][recent.y] = 2;
            }
            boolean hasDirty = false;
            for (int i = 0; i < dx.length; i++) {
                int newX = recent.x + dx[i];
                int newY = recent.y + dy[i];
                if (newX >= 0 && newY >= 0 && newX < N && newY < M) {
                    if (board[newX][newY] == 0) {
                        hasDirty = true;
                        break;
                    }
                }
            }
            if (hasDirty) {
                direction -= 1;
                if (direction < 0) {
                    direction = 3;
                }
                if (board[recent.x + dx[direction]][recent.y + dy[direction]] == 0) {
                    queue.add(new Point(recent.x + dx[direction], recent.y + dy[direction]));
                } else {
                    queue.add(new Point(recent.x, recent.y));
                }
            } else {
                if (board[recent.x - dx[direction]][recent.y - dy[direction]] == 1) {
                    return;
                }
                queue.add(new Point(recent.x - dx[direction], recent.y - dy[direction]));
            }
        }
    }

    private static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
