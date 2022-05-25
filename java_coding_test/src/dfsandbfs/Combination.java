package dfsandbfs;

import java.util.Scanner;

public class Combination {
    static int[][] ary;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int R = sc.nextInt();
        System.out.println(solution(N, R));
    }

    private static int solution(int n, int r) {
        ary = new int[n + 1][r + 1];
        if (ary[n][r] > 0) {//이미 한번 계산한 순열일 경우면 ary에서 값 가져오기
            return ary[n][r];
        }
        if (r == 0 || n == r) {
            return 1;
        } else {
            return ary[n][r] = solution(n - 1, r - 1) + solution(n - 1, r);
        }
    }
}
