package etc.dfsandbfs;

import java.util.Scanner;

public class Permutation {
    static int N;
    static int M;
    static int[] permutation;
    static int[] check;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 총 개수
        M = sc.nextInt(); // 뽑을 개수
        int[] ary = new int[N];
        for (int i = 0; i < ary.length; i++) {
            ary[i] = sc.nextInt();
        }
        solution(ary);
    }

    private static void solution(int[] ary) {
        permutation = new int[M];
        check = new int[N];
        dfs(0,ary);
    }

    private static void dfs(int L, int[] ary) {
        if (M == L) {
            for (int j : permutation) {
                System.out.print(j + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < N; i++) {
                if (check[i] == 0) {
                    permutation[L] = ary[i];
                    check[i] = 1;
                    dfs(L + 1, ary);
                    check[i] = 0;
                }
            }
        }

    }
}
