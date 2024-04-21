package etc.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra {

    static int N,M;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();//정점의 개수
        M = sc.nextInt();//간선의 개수
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        dis = new int[N + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for (int i = 0; i < M; i++) {
            graph.get(sc.nextInt()).add(new Edge(sc.nextInt(), sc.nextInt()));
        }
        solution(1);

        for (int i = 2; i <= N; i++) {
            if (dis[i] != Integer.MAX_VALUE) {
                System.out.println(i + " : " + dis[i]);
            } else {
                System.out.println(i + " impossible");
            }
        }
    }

    private static void solution(int vertex) {
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.offer(new Edge(vertex, 0));
        dis[vertex] = 0;
        while (!queue.isEmpty()) {
            Edge current = queue.poll();
            int currentCost = current.getCost();
            int currentVertex = current.getVertex();
            if (currentCost > dis[currentVertex]) {
                continue;
            }
            for (Edge edge : graph.get(currentVertex)) {
                int nextCost = currentCost + edge.getCost();
                if (dis[edge.getVertex()] > edge.getCost()) {
                    dis[edge.getVertex()] = nextCost;
                    queue.offer(new Edge(edge.getVertex(), nextCost));
                }
            }

        }
    }
}
class Edge implements Comparable<Edge> {
    private int vertex;
    private int cost;

    public Edge(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    public int getVertex() {
        return vertex;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.getCost() - o.getCost();//비용 기준 오름차순 정렬
    }
}