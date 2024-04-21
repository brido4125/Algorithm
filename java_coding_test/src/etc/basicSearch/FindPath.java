package etc.basicSearch;

import java.util.LinkedList;
import java.util.Scanner;

public class FindPath {
    static int n,m, answer = 0;
    static int[][] graphByMatrix;
    static LinkedList<LinkedList<Integer>> graphByList; // integer를 저장하는 list의 list
    static int[] ch;

    /*
    * 경로탐색 -> DFS
    * */
    public static void DFS(int v) {
        if (v == n) {
            answer++;
        } else {
            for (int i = 1; i < n; i++) {
                if (graphByMatrix[v][i] == 1 && ch[i] == 0) {
                    ch[i] = 1; //check 검
                    DFS(i);
                    ch[i] = 0; // check 풀어줌
                }
            }
        }
    }

    public static void DFS2(int v) {
        if (v == n) {
            answer++;
        } else {
            for (int nv : graphByList.get(v)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();//총 노드의 수
        m = sc.nextInt();//총 간선의 수
        graphByMatrix = new int[n + 1][n + 1];
        graphByList = new LinkedList<LinkedList<Integer>>();
        //세로로 길게 다는 작업
        for (int i = 0; i <= n; i++) {
            graphByList.add(new LinkedList<Integer>());
        }
        ch = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graphByMatrix[a][b] = 1;
            graphByList.get(a).add(b);
        }
        ch[1] = 1;// check, 즉 방문여부 체크
        DFS(1);
        System.out.println("answer = " + answer);
    }
}
