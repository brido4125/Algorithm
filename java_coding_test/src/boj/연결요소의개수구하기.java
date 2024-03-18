package boj;

import java.io.*;
import java.util.*;

public class 연결요소의개수구하기 {
    private static boolean[] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        checked = new boolean[n + 1];

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0 ; i <= n ; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        for (int i = 0 ; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adjList.get(start).add(end);
            adjList.get(end).add(start);
        }

        int sum = 0;
        for (int i = 1 ; i <= n; i++) {
            if (!checked[i]) {
                checked[i] = true;
                dfs(i, adjList);
                sum += 1;
            }
        }

        System.out.println(sum);
    }

    private static void dfs(int start, List<List<Integer>> adjList) {
        for (Integer node : adjList.get(start)) {
            if (!checked[node]) {
                checked[node] = true;
                dfs(node, adjList);
            }
        }
    }
}
