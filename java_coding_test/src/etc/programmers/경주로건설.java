package etc.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 경주로건설 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int size;

    public int solution(int[][] board) {
        size = board.length;
        return Math.min(bfs(0,0,0,2,board),
            bfs(0,0,0,3,board));
    }

    public static int bfs(int startX, int startY, int cost, int path, int[][] board) {
        int[][] graph = new int[size][size];

        for (int a = 0; a < size; a++) {
            for (int b = 0; b < size; b++) {
                if (board[a][b] == 1)
                    graph[a][b] = -1;
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, cost, path});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int recentX = current[0];
            int recentY = current[1];
            int recentCost = current[2];
            int recentPath = current[3];

            for (int i = 0; i < dx.length; i++) {
                int nx = recentX + dx[i];
                int ny = recentY + dy[i];

                if (nx < 0 || nx >= size || ny < 0 || ny >= size || graph[nx][ny] == -1)
                    continue;

                int newCost = recentCost + 100;
                if (recentPath != i) {
                    newCost += 500;
                }

                if (graph[nx][ny] == 0 || (graph[nx][ny] != 0 && graph[nx][ny] > newCost)) {
                    queue.add(new int[]{nx, ny, newCost, i});
                    graph[nx][ny] = newCost;
                }
            }
        }
        return graph[size - 1][size - 1];
    }
}
