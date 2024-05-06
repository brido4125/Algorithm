package study.brido.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 돌게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int cnt = 0;

        while (N > 0) {
            if (N >= 3) {
                N -= 3;
            } else {
                N -= 1;
            }
            cnt += 1;
        }
        if (cnt % 2 != 0) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}
