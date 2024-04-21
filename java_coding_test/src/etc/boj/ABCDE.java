package etc.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ABCDE {

    private static boolean[] checked;
    private static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer N = Integer.valueOf(st.nextToken());
        Integer M = Integer.valueOf(st.nextToken());

        checked = new boolean[N];

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adjList.get(start).add(end);
            adjList.get(end).add(start);
        }

        for (int i = 0; i < N; i++) {
            if (flag) {
                break;
            }
            if (!checked[i]) {
                checked[i] = true;
                dfs(0, i, adjList);
                checked[i] = false;
            }
        }

        if (flag) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static void dfs(int level, int start, List<List<Integer>> adjList) {
        if (level == 4) {
            flag = true;
            return;
        }

        for (Integer i : adjList.get(start)) {
            if (!checked[i]) {
                checked[i] = true;
                dfs(level + 1, i, adjList);
                checked[i] = false;
            }
        }
    }
}
