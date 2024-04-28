package study.brido.week2;

import java.util.*;

public class 양과늑대 {
    static boolean[] checked;
    static int wolf;
    static int sheep;

    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0 ; i < info.length ; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        checked = new boolean[info.length];

        List<Integer> answerList = new ArrayList<>();
        //문제 : 1번 노드에서 시작할 때, 0번말고 4번을 먼저 갈 경우 정답이 X
        for (int i = 0 ; i < info.length; i++) {
            if (info[i] == 0) {
                sheep = 1;
                wolf = 0;
                checked[i] = true;
                dfs(i, adjList, info);
                checked[i] = false;
                answerList.add(sheep);
            }
        }
        return Collections.max(answerList);
    }

    private static void dfs(int start, List<List<Integer>> adjList, int[] info){
        // 늑대 leaf 노드면 갈 필요 없음
        if (info[start] == 1 && adjList.get(start).size() == 1) {
            wolf -= 1;
            return;
        }
        for (Integer v : adjList.get(start)) {
            if (!checked[v] && info[v] == 0) {
                checked[v] = true;
                sheep += 1;
                dfs(v, adjList, info);
                checked[v] = false;
            } else if (!checked[v] && info[v] == 1 && sheep - wolf > 1) {
                checked[v] = true;
                wolf += 1;
                dfs(v, adjList, info);
                checked[v] = false;
            }
        }
    }
}
