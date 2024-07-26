package study.brido.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class FourSquares {

    private static Set<Integer> nums = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
//        System.out.println(Math.pow(224, 2)); -> 50716

        int N = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= Math.sqrt(N); i++) {
            nums.add((int) Math.pow(i, 2));
        }

        for (Integer i : nums) {
            System.out.println(dp(N, i));
        }
    }

    public static int dp(int N, int ceil) {
        if (nums.contains(N)) {
            return 1;
        }
        return dp(ceil) + dp(N - ceil);
    }
}
