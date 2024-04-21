package etc.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class K번째최단경로찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<List<Edge>> adjList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            adjList.get(start).add(new Edge(end, value));
        }


    }

    public static class Edge {
        int node;
        int value;

        public Edge(int node, int value) {
            this.node = node;
            this.value = value;
        }
    }
}
