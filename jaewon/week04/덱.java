import java.io.*;
import java.util.*;

public class Main {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int L;
    int C;
    int[][] map;
    boolean[][] visited;
    int result;
    int[] dLine = new int[] { 0, 0, -1, 1 };
    int[] dCol = new int[] { -1, 1, 0, 0 };

    private void sol() throws Exception {
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[L][C];
        visited = new boolean[L][C];

        for (int l = 0; l < L; l++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                map[l][c] = Integer.parseInt(st2.nextToken());
            }
        }

        for (int l = 0; l < L; l++) {
            for (int c = 0; c < C; c++) {
                visited[l][c] = true;
                backTracking(l, c, 1, map[l][c]);
                visited[l][c] = false;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }

    private void backTracking(int l, int c, int depth, int sum) {
        if (depth == 4) {
            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i < 4; ++i) {
            int nextLine = l + dLine[i];
            int nextCol = c + dCol[i];

            if (nextLine < 0 || nextLine >= L || nextCol < 0 || nextCol >= C) continue;
            if (visited[nextLine][nextCol]) continue;
            
            visited[nextLine][nextCol] = true;
            backTracking(nextLine, nextCol, depth + 1, sum + map[nextLine][nextCol]);
            visited[nextLine][nextCol] = true;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
