import java.util.*;

class Solution {
    int[] nodes;
    List<List<Integer>> graph;
    int answer = 0;

    public int solution(int[] info, int[][] edges) {
        nodes = info;
        graph = new ArrayList<>();
        for (int i = 0; i < info.length; ++i) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        List<Integer> vis = new LinkedList<>();
        vis.add(0);

        dfs(vis, 0, 0, 0);

        return answer;
    }

    private void dfs(List<Integer> vis, int node, int sheepCnt, int wolfCnt) {
        if (nodes[node] == 1) { // wolf
            wolfCnt++;
        } else {
            sheepCnt++;
        }
        if (sheepCnt <= wolfCnt) {
            return;
        }
        answer = Math.max(answer, sheepCnt);

        List<Integer> next = new ArrayList<>(vis);
        if (!graph.get(node).isEmpty()) { // 방문할 자식 노드가 있다면
            next.addAll(graph.get(node)); // 다음에 방문할 걸로 추가
        }
        next.remove(Integer.valueOf(node)); // node 방문 삭제

        for (int n : next) {
            dfs(next, n, sheepCnt, wolfCnt);
        }
    }

}
