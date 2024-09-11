package study.brido.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 케빈베이컨의6단계법칙 {

    static boolean[] checked;
    static int[] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= node; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adjList.get(start).add(end);
            adjList.get(end).add(start);
        }

        int[] sumAry = new int[node + 1];

        for (int i = 1; i <= node; i++) {
            checked = new boolean[node + 1];
            cost = new int[node + 1];
            checked[i] = true;
//            dfs(i, adjList, 0);
            bfs(i, adjList);
            int sum = 0 ;
            for (Integer k : cost) {
                sum += k;
            }
            sumAry[i] = sum;
        }

        int answer = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= node; i++) {
            if (min > sumAry[i]) {
                min = sumAry[i];
                answer = i;
            }
        }

        System.out.println(answer);
    }

    private static void bfs(int start, List<List<Integer>> list) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        checked[start] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            cost[poll[0]] = poll[1];
//            if (cost[poll[0]] == 0) {
//            } else {
//                cost[poll[0]] = Math.min(cost[poll[0]], poll[1]);
//            }
            List<Integer> integers = list.get(poll[0]);
            for (Integer i : integers) {
                if (!checked[i]) {
                    checked[i] = true;
                    queue.add(new int[]{i, poll[1] + 1});
                }
            }
        }
    }

    /*
    * bfs는 통과 dfs는 시간 초과 -> 테이트 케이스에서 편향 트리가 있으면 dfs는 시간 초과 발생확률 증가
    * */
    private static void dfs(int start, List<List<Integer>> list, int depth) {
        if (cost[start] == 0) {
            cost[start] = depth;
        } else {
            cost[start] = Math.min(depth, cost[start]);
        }

        for (Integer i : list.get(start)) {
            if (!checked[i]) {
                checked[i] = true;
                dfs(i, list, depth + 1);
                checked[i] = false;
            }
        }
    }
}
