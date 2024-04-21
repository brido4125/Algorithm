package etc.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수들의합5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int start = 1;
        int end = 1;
        int sum = 1;
        int count = 1;

        while (end < N) {
            if (sum < N) {
                end += 1;
                sum += end;
            } else if (sum > N) {
                sum -= start;
                start += 1;
            } else {
                count += 1;
                end += 1;
                sum += end;
            }
        }
        System.out.println(count);
    }
}
