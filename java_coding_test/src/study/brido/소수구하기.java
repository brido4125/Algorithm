package study.brido;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for (int i = N; i <= M; i++) {
            if (i == 1) {
                continue;
            }
            if (isPrime(i)) {
                sb.append(i);
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean isPrime(int t) {
        if (t == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(t); i++) {
            if (t % i == 0) {
                return false;
            }
        }
        return true;
    }
}
