package study.brido.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class FourSquares {

    private static Set<Integer> nums = new HashSet<>();
    static int[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
//        System.out.println(Math.pow(224, 2)); -> 50716

        int N = Integer.parseInt(st.nextToken());

        board = new int[N + 1];

        for (int i = 1; i <= Math.sqrt(N); i++) {
            nums.add((int) Math.pow(i, 2));
        }

        System.out.println(dp(N));
    }

    public static int dp(int N) {
        if (nums.contains(N)) {
            board[N] = 1;
        }
        int ceil = (int) Math.pow(Math.floor(Math.sqrt(N)), 2);
        return dp(ceil) + dp(N - ceil);
    }
}
