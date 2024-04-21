package etc.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트리의지름 {

    public static class Edge {
        private final int node;
        private final int distance;

        public Edge(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        public int getNode() {
            return node;
        }

        public int getDistance() {
            return distance;
        }
    }

    private static boolean[] checked;
    private static int[] acc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer V = Integer.valueOf(st.nextToken());
        List<List<Edge>> adjList = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            while (true) {
                int end = Integer.parseInt(st.nextToken());
                if (end == -1) {
                    break;
                }
                int P = Integer.parseInt(st.nextToken());
                adjList.get(start).add(new Edge(end, P));
                adjList.get(end).add(new Edge(start, P));
            }
        }

        acc = new int[V + 1];

        checked = new boolean[V + 1];
        checked[2] = true;
        bfs(2, adjList);

        int farNode = 0;
        int max = 0;
        for (int i = 1; i < V + 1; i++) {
            if (max < acc[i]) {
                max = acc[i];
                farNode = i;
            }
        }

        checked = new boolean[V + 1];
        checked[farNode] = true;
        acc = new int[V + 1];

        bfs(farNode, adjList);

        System.out.println(Arrays.stream(acc).max().getAsInt());
    }

    private static void bfs(int start, List<List<Edge>> adjList) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (Edge e : adjList.get(poll)) {
                if (!checked[e.getNode()]) {
                    checked[e.getNode()] = true;
                    acc[e.getNode()] += (acc[poll] + e.getDistance());
                    queue.add(e.node);
                }
            }
        }
    }
}
