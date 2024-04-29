package study.brido.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 분수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        // num이 몇번째 줄인지
        int n = 1;
        while (true) {
            if (n * (n - 1) / 2 + 1 <= x && (n + 1) * n / 2 >= x) break;
            else n++;
        }

        int i, j;
        if (n % 2 == 0) {
            i = x - (n - 1) * n / 2;
            j = (n + 1) - i;
        }
        else {
            j = x - (n - 1) * n / 2;
            i = (n + 1) - j;
        }
        System.out.println(i + "/" + j);
    }
}
