import java.io.*;
import java.util.*;

public class Main {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int L;
    int C;
    int[][] map;
    boolean[][] visited;
    int result = -1;
    int[] dLine = new int[] { -1, 1, 0, 0 };
    int[] dCol = new int[] { 0, 0, -1, 1 };

    private void sol() throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[L][C];
        visited = new boolean[L][C];

        for (int l = 0; l < L; l++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                map[l][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int l = 0; l < L; l++) {
            for (int c = 0; c < C; c++) {
                visited[l][c] = true;
                dfs(l, c, 1, map[l][c]);
                visited[l][c] = false;

                combi(l, c, 0, 0, map[l][c]); // 인접한 4칸 중 3칸 선택 (ㅗ,ㅓ,ㅏ,ㅜ 모양)
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }

    private void dfs(int l, int c, int cnt, int sum) {
        if (cnt == 4) {
            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i < 4; ++i) {
            int nextLine = l + dLine[i];
            int nextCol = c + dCol[i];

            if (nextLine < 0 || nextLine >= L || nextCol < 0 || nextCol >= C)
                continue;
            if (visited[nextLine][nextCol])
                continue;

            visited[nextLine][nextCol] = true;
            dfs(nextLine, nextCol, cnt + 1, sum + map[nextLine][nextCol]);
            visited[nextLine][nextCol] = false;
        }
    }

    private void combi(int l, int c, int cnt, int start, int sum) {
        if (cnt == 3) {
            result = Math.max(result, sum);
            return;
        }

        for (int i = start; i < 4; ++i) {
            int nLine = l + dLine[i];
            int nCol = c + dCol[i];

            if (nLine < 0 || nLine >= L || nCol < 0 || nCol >= C)
                continue;

            combi(l, c, cnt + 1, i + 1, sum + map[nLine][nCol]);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
