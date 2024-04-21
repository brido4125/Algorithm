package study.brido.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class 합승택시요금 {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        List<List<Edge>> adjList = new ArrayList<>();
        for (int i = 0 ; i < n + 1 ; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int [] fare : fares) {
            int start = fare[0];
            int end = fare[1];
            int value = fare[2];

            adjList.get(start).add(new Edge(end, value));
            adjList.get(end).add(new Edge(start, value));
        }

        int[][] totalCost = new int[n + 1][n + 1];

        getMinCost(s, n, adjList, totalCost);
        getMinCost(a, n, adjList, totalCost);
        getMinCost(b, n, adjList, totalCost);

        List<Integer> price = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            price.add(totalCost[s][i] + totalCost[a][i] + totalCost[b][i]);
        }
        return Collections.min(price);
    }

    private static int[] getMinCost(int start, int n, List<List<Edge>> adjList, int[][] ary) {
        int[] costAry = ary[start];
        boolean[] checked = new boolean[n + 1];
        Arrays.fill(costAry, Integer.MAX_VALUE);
        costAry[start] = 0;

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(start, 0));

        while(!queue.isEmpty()) {
            Edge recent = queue.poll();
            if (!checked[recent.node]) {
                checked[recent.node] = true;
                for (Edge e : adjList.get(recent.node)) {
                    costAry[e.node] = Math.min(costAry[e.node], e.value + costAry[recent.node]);
                    queue.add(new Edge(e.node, costAry[e.node]));
                }
            }
        }
        return costAry;
    }

    public static class Edge implements Comparable<Edge> {
        int node;
        int value;

        public Edge(int node, int value) {
            this.node = node;
            this.value = value;
        }

        public int compareTo(Edge e) {
            return Integer.compare(this.value, e.value);
        }
    }
}
