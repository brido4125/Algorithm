package study.brido.week5;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class 뱀 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int[][] board = new int[N][N];
        for (int i = 0; i < K; i++) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            board[row - 1][col - 1] = 1; // 사과는 board에서 1로 지정
        }
        int L = scanner.nextInt();
        Map<Integer, Character> times = new HashMap<>();
        for (int i = 0; i < L; i++) {
            int X = scanner.nextInt();
            char C = scanner.next().charAt(0);
            times.put(X, C);
        }
        scanner.close();

        int[] dy = {-1, 0, 1, 0}; // 위, 우측, 아래, 좌측 방향
        int[] dx = {0, 1, 0, -1};

        int direction = 1;
        int time = 1;
        int x = 0;
        int y = 0;
        board[y][x] = 2; // 뱀이 처음 시작할때 있는 위치
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});

        while (true) {
            y += dy[direction];
            x += dx[direction];

            if (0 <= y && y < N && 0 <= x && x < N && board[y][x] != 2) {
                if (board[y][x] != 1) { // 사과가 없는 곳
                    int[] tail = queue.poll();
                    board[tail[0]][tail[1]] = 0; // 사과가 없으니 원래 뱀이 있던 곳은 0으로 변경
                }
                board[y][x] = 2; // 뱀이 옮겨간 위치는 2로 변경
                queue.offer(new int[]{y, x});
                if (times.containsKey(time)) {
                    direction = directionChange(direction, times.get(time));
                }
                time += 1;
            } else { // 뱀이 벽이나 자기 자신에 부딪혀서 게임이 끝나는 경우
                break;
            }
        }

        System.out.println(time);
    }

    private static int directionChange(int d, char c) {
        if (c == 'L') {
            d = (d - 1 + 4) % 4;
        } else {
            d = (d + 1) % 4;
        }
        return d;
    }
}
