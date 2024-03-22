package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소 {

    static Point[] combi = new Point[3];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int M;
    static int[][] board;
    static List<Integer> safeZoneCountList;
    static boolean[] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로

        board = new int[N][M];

        /*
        * 1. 벽을 세울 곳 == 0인 지점 찾기.
        * 2. 바이러스 퍼트리기.
        * 3. 안전지대 구하기.
        * 위 3개를 모든 벽을 세울 수 있는 경우만큼 반복
        * */

        List<Point> wallList = new ArrayList<>();
        List<Point> virusList = new ArrayList<>();
        safeZoneCountList = new ArrayList<>();



        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 0) {
                    wallList.add(new Point(i, j));
                } else if (num == 2) {
                    virusList.add(new Point(i, j));
                }
                board[i][j] = num;
            }
        }
        checked = new boolean[wallList.size()];
        combination(0, 0, wallList, virusList);

        // 벽 3군데를 뽑는 경우의 수
//        for (int i = 0; i < wallList.size(); i++) {
//            for (int j = 0; j < i; j++) {
//                for (int k = 0; k < j; k++) {
//                    // 벽 3군데를 세우기
//                    board[wallList.get(i).x][wallList.get(i).y] = 1;
//                    board[wallList.get(j).x][wallList.get(j).y] = 1;
//                    board[wallList.get(k).x][wallList.get(k).y] = 1;
//
//                    // virus 퍼트리기 -> bfs
//                    safeZoneCountList.add(bfs(board, virusList));
//
//                    // 원복 후, 다른 케이스 탐색
//                    board[wallList.get(i).x][wallList.get(i).y] = 0;
//                    board[wallList.get(j).x][wallList.get(j).y] = 0;
//                    board[wallList.get(k).x][wallList.get(k).y] = 0;
//                }
//            }
//        }
        System.out.println(Collections.max(safeZoneCountList));
    }

    private static void combination(int L, int index, List<Point> wallList, List<Point> virusList) {
        if (L == 3) {
            board[combi[0].x][combi[0].y] = 1;
            board[combi[1].x][combi[1].y] = 1;
            board[combi[2].x][combi[2].y] = 1;

            // virus 퍼트리기 -> bfs
            safeZoneCountList.add(bfs(board, virusList));

            // 원복 후, 다른 케이스 탐색
            board[combi[0].x][combi[0].y] = 0;
            board[combi[1].x][combi[1].y] = 0;
            board[combi[2].x][combi[2].y] = 0;
            return;
        }
        for (int i = index; i < wallList.size(); i++) {
            if (!checked[i]) {
                combi[L] = wallList.get(i);
                checked[i] = true;
                combination(L + 1, index + 1, wallList, virusList);
                checked[i] = false;
            }
        }

    }

    private static int bfs(int[][] board, List<Point> virus) {
        int[][] copy = new int[board.length][board[0].length];
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[i].length; j++) {
                copy[i][j] = board[i][j];
            }
        }

        //virus 퍼트리기
        Queue<Point> queue = new LinkedList<>(virus);
        while (!queue.isEmpty()) {
            Point recent = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = recent.x + dx[i];
                int ny = recent.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && copy[nx][ny] == 0) {
                    copy[nx][ny] = 2;
                    queue.add(new Point(nx, ny));
                }
            }
        }

        int sum = 0;

        //안전 지대 찾기
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[i].length; j++) {
                if (copy[i][j] == 0) {
                    sum += 1;
                }
            }
        }
        return sum;
    }

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
