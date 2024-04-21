package etc.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최단경로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer V = Integer.valueOf(st.nextToken());
        Integer E = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Integer start = Integer.valueOf(st.nextToken());

        List<List<Edge>> adjList = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            Integer u = Integer.valueOf(st.nextToken());
            Integer v = Integer.valueOf(st.nextToken());
            Integer w = Integer.valueOf(st.nextToken());
            adjList.get(u).add(new Edge(v, w));
        }

        boolean[] checked = new boolean[V + 1];
        int[] distance = new int[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(start, 0));
        while (!queue.isEmpty()) {
            Edge poll = queue.poll();
            if (!checked[poll.node]) {
                checked[poll.node] = true;
                for (Edge e : adjList.get(poll.node)) {
                    distance[e.node] = Math.min(e.value + distance[poll.node], distance[e.node]);
                    // queue.add(e); 하면 error -> 기존의 거리보다 갱신한 거리가 작은 값일 수 있다.
                    queue.add(new Edge(e.node, distance[e.node]));
                }
            }
        }
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }

    public static class Edge implements Comparable<Edge> {
        private final int node;
        private final int value;

        public Edge(int node, int value) {
            this.node = node;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.value, o.value);
        }
    }

}
