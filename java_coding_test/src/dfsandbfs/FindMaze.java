package dfsandbfs;

import java.util.Scanner;

public class FindMaze {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int count = 0;
    static int[][] maze;
    public static void main(String[] args) {
        maze = new int[8][8];
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i < maze.length; i++) {
            for (int j = 1; j < maze[i].length; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        maze[1][1] = 1;
        dfs(1,1);
        System.out.println(count);
    }

    private static void dfs(int x, int y) {
        if (x == 7 && y == 7) {
            count++;
        } else {
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if (nextX >= 1 && nextX <= 7 && nextY >= 1 && nextY <= 7 && maze[nextX][nextY] == 0) {
                    maze[nextX][nextY] = 1;
                    dfs(nextX,nextY);
                    maze[nextX][nextY] = 0;
                }
            }
        }
    }
}
