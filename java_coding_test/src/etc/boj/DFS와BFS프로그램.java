package etc.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와BFS프로그램 {

    private static boolean[] checked;
    private static List<Integer> dfsList = new ArrayList<>();
    private static List<Integer> bfsList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer N = Integer.valueOf(st.nextToken());
        Integer M = Integer.valueOf(st.nextToken());
        Integer V = Integer.valueOf(st.nextToken());

        checked = new boolean[N + 1];

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adjList.get(start).add(end);
            adjList.get(end).add(start);
        }


        dfsList.add(V);

        checked[V] = true;
        dfs(V, adjList);

        System.out.println();

        checked = new boolean[N + 1];
        checked[V] = true;
        bfs(V, adjList);
    }

    private static void dfs(int start, List<List<Integer>> adjList) {
        System.out.print(start + " ");
        Collections.sort(adjList.get(start));
        for (Integer i : adjList.get(start)) {
            if (!checked[i]) {
                dfsList.add(i);
                checked[i] = true;
                dfs(i, adjList);
            }
        }
    }

    private static void bfs(int start, List<List<Integer>> adjList) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            System.out.print(poll + " ");
            bfsList.add(poll);
            for (Integer i : adjList.get(poll)) {
                if (!checked[i]) {
                    checked[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
