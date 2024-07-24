package study.brido.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2xN타일링2 {

    static int[] ary = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        // n == 1 -> 1
        // n == 2 -> 3
        ary[1] = 1;
        ary[2] = 3;
        System.out.println(dp(N));
    }

    static int dp(int n) {
        if (n == 1) {
            return ary[1];
        } else if (n == 2) {
            return ary[2];
        }
        if (ary[n] != 0) {
            return ary[n];
        } else if (ary[n - 1] != 0 && ary[n - 2] != 0) {
            ary[n] = (ary[n - 1] + 2 * ary[n - 2]) % 10007;
        }
        return (dp(n - 1) + 2 * dp(n - 2)) % 10007;
    }
}
