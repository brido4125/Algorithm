import java.io.*;
import java.util.*;

public class Main {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int[] dLine = { 0, 1, 0, -1 }; // 시계 방향 동,남,서,북
    int[] dCol = { 1, 0, -1, 0 };

    private static class Pair {
        int line;
        int col;

        public Pair(int line, int col) {
            this.line = line;
            this.col = col;
        }
    }

    private static class TurnInfo {
        int time;
        char c;

        public TurnInfo(int time, char c) {
            this.time = time;
            this.c = c;
        }
    }

    private void sol() throws Exception {
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[][] table = new int[N][N]; // 1: 사과, 2: 뱀
        String[] tokens = null;
        for (int i = 0; i < K; ++i) {
            tokens = br.readLine().split(" ");
            int line = Integer.parseInt(tokens[0]) - 1;
            int col = Integer.parseInt(tokens[1]) - 1;
            table[line][col] = 1;
        }

        int line = 0;
        int col = 0;
        int dir = 0;
        int L = Integer.parseInt(br.readLine());
        int time = -1;
        List<Pair> snake = new LinkedList<>();
        snake.add(new Pair(0, 0));
        table[0][0] = 2;

        List<TurnInfo> infos = new LinkedList<>();
        for (int i = 0; i < L; ++i) {
            tokens = br.readLine().split(" ");
            int X = Integer.parseInt(tokens[0]);
            char C = tokens[1].charAt(0);
            infos.add(new TurnInfo(X, C));
        }
        for (time = 1;; time++) {
            line += dLine[dir];
            col += dCol[dir];
            if (line < 0 || line >= N || col < 0 || col >= N) {
                break;
            }
            if (table[line][col] == 2) {
                break;
            }
            snake.add(0, new Pair(line, col));
            if (table[line][col] != 1) {
                Pair moved = snake.remove(snake.size() - 1);
                table[moved.line][moved.col] = 0;
            }
            table[line][col] = 2;
            if (!infos.isEmpty() && time == infos.get(0).time) {
                var info = infos.get(0);
                infos.remove(0);
                if (info.c == 'L') { // 왼쪽 : 반시계
                    dir -= 1;
                    if (dir < 0)
                        dir = 3;
                } else if (info.c == 'D') { // 오른쪽 : 시계
                    dir = (dir + 1) % 4;
                }
            }
            // for (int a = 0; a < N; ++a) {
            // for (int b = 0; b < N; ++b) {
            // System.out.print(table[a][b] + " ");
            // }
            // System.out.println();
            // }
            // System.out.println(time);
        }
        System.out.println(time);
    }

    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
