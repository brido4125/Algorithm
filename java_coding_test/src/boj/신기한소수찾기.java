package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 신기한소수찾기 {

    private static int[] tmp;
    private static int[] odds = {1, 3, 5, 7, 9};
    private static int N;
    private static int[] recent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        tmp = new int[N];
        recent = new int[N];
        List<Integer> pList = List.of(2, 3, 5, 7);
        for (Integer prime : pList) {
            dfs(prime, 0, String.valueOf(prime));
        }

    }

    private static void dfs(int start, int level, String acc) {
        if (level == N) {
            if (!Arrays.equals(recent, tmp)) {
                recent = Arrays.copyOf(tmp, N);
                for (Integer i : recent) {
                    System.out.print(i);
                }
                System.out.println();
            }
            return;
        }

        for (int odd : odds) {
            if (isPrime(Integer.parseInt(acc))) {
                tmp[level] = start;
                dfs(odd, level + 1, acc + odd);
            }
        }
    }

    private static boolean isPrime(int target) {
        for (int i = 2; i <= target / 2; i++) {
            if (target % i == 0) {
                return false;
            }
        }
        return true;
    }
}
