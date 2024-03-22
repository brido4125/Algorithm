package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 최소비용구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        List<List<Bus>> adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }
        int[] costAry = new int[N + 1];
        Arrays.fill(costAry, Integer.MAX_VALUE);
        boolean[] checked = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adjList.get(start).add(new Bus(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        costAry[start] = 0;

        PriorityQueue<Bus> queue = new PriorityQueue<>();
        queue.add(new Bus(start, 0));

        while (!queue.isEmpty()) {
            Bus recent = queue.poll();
            if (!checked[recent.destination]) {
                checked[recent.destination] = true;
                for (Bus b : adjList.get(recent.destination)) {
                    costAry[b.destination] = Math.min(b.cost + costAry[recent.destination], costAry[b.destination]);
                    queue.add(new Bus(b.destination, costAry[b.destination]));
                }
            }
        }

        System.out.println(costAry[end]);
    }

    static class Bus implements Comparable<Bus> {
        int destination;
        int cost;

        public Bus(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }

        @Override
        public int compareTo(Bus o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
