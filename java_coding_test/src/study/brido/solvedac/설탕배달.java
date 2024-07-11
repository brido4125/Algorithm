package study.brido.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 설탕배달 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        if (N % 5 == 0) {
            System.out.println(N / 5);
            return;
        }

        int sum = 0;
        for (int i = N / 5; i > 0; i--) {
            int three = N - (i * 5);
            if (three >= 3 && three % 3 == 0) {
                sum += i;
                sum += three / 3;
                System.out.println(sum);
                return;
            }
        }

        if (N % 3 == 0) {
            System.out.println(N / 3);
            return;
        }
        System.out.println(-1);
    }
}
