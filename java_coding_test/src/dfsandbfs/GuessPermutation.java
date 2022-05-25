package dfsandbfs;

import java.util.Scanner;

public class GuessPermutation {
    static int[] combination;
    static int[] values;
    static int[] checks;
    static int N;
    static int lastNum;
    static boolean flag = false;
    public static void main(String[] args) {
        //주어지는 값 : 첫번째 줄 숫자의 갯수, 가장 아래에 있는 값
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        lastNum = sc.nextInt();
        solution(N, lastNum);
    }

    private static void solution(int n, int lastNum) {
        combination = new int[n];
        for (int i = 0; i < combination.length; i++) {
            combination[i] = getComb(n - 1, i);
        }
        values = new int[n];
        checks = new int[n + 1];
        dfs(0, 0);
    }

    private static void dfs(int L, int sum) {
        if (flag) {
            return;
        }
        if (L == N) {
            if (sum == lastNum) {
                for (int value : values) {
                    System.out.print(value + " ");
                }
                flag = true;
                System.out.println();
            }
        } else {
            for (int i = 1; i <= N ; i++) {
                if (checks[i] == 0) {
                    checks[i] = 1;
                    values[L] = i;
                    dfs(L + 1, sum+(combination[L]*values[L]));
                    checks[i] = 0;
                }
            }
        }
    }
    private static int getComb(int n, int r) {
        if (n == r || r == 0) {
            return 1;
        } else {
            return getComb(n - 1, r - 1) + getComb(n - 1, r);
        }
    }
}
