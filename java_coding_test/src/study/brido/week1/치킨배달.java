package study.brido.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 치킨배달 {

    static List<Point> chikenList = new ArrayList<>();
    static List<Point> homeList = new ArrayList<>();
    static boolean[] checked;
    static int[][] board;
    static List<Integer> answerList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) {
                    chikenList.add(new Point(j, i));
                } else if (board[i][j] == 1) {
                    homeList.add(new Point(j, i));
                }
            }
        }

        Point[] combi;
        for (int i = 1; i <= M; i++) {
            checked = new boolean[chikenList.size()];
            combi = new Point[i];
            combination(0, 0, i, combi);
        }
        System.out.println(Collections.min(answerList));
    }

    private static void combination(int level, int index, int M, Point[] combi) {
        if (level == M) {
            answerList.add(getMinDistance(combi));
            return;
        }
        for (int i = index; i < chikenList.size(); i++) {
            if (!checked[i]) {
                combi[level] = chikenList.get(i);
                checked[i] = true;
                combination(level + 1, i + 1, M, combi);
                checked[i] = false;
            }
        }
    }

    private static int getMinDistance(Point[] chickenList) {
        int result = 0;
        for (Point home : homeList) {
            int min = Integer.MAX_VALUE;
            for (Point chicken : chickenList) {
                int calc = Math.abs(chicken.x - home.x) + Math.abs(chicken.y - home.y);
                if (min > calc) {
                    min = calc;
                }
            }
            result += min;
        }
        return result;
    }

    public static class Point {
        int x; int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return this.x + " " + this.y;
        }
    }

}
