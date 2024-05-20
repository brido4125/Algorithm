package study.brido.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어 {
    static int[] dy = {-1, 0, 1, 0}; // 위, 우측, 아래, 좌측 방향
    static int[] dx = {0, 1, 0, -1};

    static Map<Integer, List<int[]>> pointMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][N];

        int[] start = null;

        pointMap = new HashMap<>();
        for (int i = 1; i <= 6; i++) {
            pointMap.put(i, new ArrayList<>());
        }


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 9) {
                    start = new int[]{i, j};
                    num = 0;
                } else if (num == 1) {
                    pointMap.get(1).add(new int[]{i, j});
                } else if (num == 2) {
                    pointMap.get(2).add(new int[]{i, j});
                } else if (num == 3) {
                    pointMap.get(3).add(new int[]{i, j});
                } else if (num == 4) {
                    pointMap.get(4).add(new int[]{i, j});
                } else if (num == 5) {
                    pointMap.get(5).add(new int[]{i, j});
                } else if (num == 6) {
                    pointMap.get(6).add(new int[]{i, j});
                }
                board[i][j] = num;
            }
        }

        int babySize = 2;
        int time = 0;
        int eaten = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int[] near = findNear(babySize, poll[0], poll[1], board);
            if (near == null) {
                break;
            }
            time += near[2];
            eaten += 1;
            board[near[0]][near[1]] = 0;
            if (babySize == eaten) {
                babySize += 1;
                eaten = 0;
            }
            queue.add(new int[]{near[0], near[1]});
        }

        System.out.println(time);
    }

    private static int[] findNear(int babySize, int n, int m, int[][] board) {
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] > 0 && babySize > board[i][j]) {
                    list.add(new int[]{i, j});
                }
            }
        }

        if (list.isEmpty()) {
            return null;
        }

        int result = Integer.MAX_VALUE;
        int[] resultPoint = null;

        for (int[] target : list) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{n, m, 0});
            int distance = 0;

            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                if (poll[0] == target[0] && poll[1] == target[1]) {
                    distance = poll[2];
                    break;
                }
                for (int i = 0; i < 4; i++) {
                    int newN = poll[0] + dy[i];
                    int newM = poll[1] + dx[i];
                    if (0 <= newN && newN < board.length &&
                        0 <= newM && newM < board.length &&
                        board[newN][newM] <= babySize) {
                        queue.add(new int[]{newN, newM, poll[2] + 1});
                    }
                }
            }

            if (result > distance) {
                result = distance;
                resultPoint = target;
            } else if (result == distance) {
                //Distance가 같은 경우 위쪽, 왼쪽 순으로 먹이 찾기
                if (resultPoint[0] == target[0]) {
                    if (resultPoint[1] > target[1]) {
                        resultPoint = target;
                    }
                } else if (resultPoint[0] > target[0]) {
                    resultPoint = target;
                }
            }
        }
        return new int[]{resultPoint[0], resultPoint[1], result};
    }
}
