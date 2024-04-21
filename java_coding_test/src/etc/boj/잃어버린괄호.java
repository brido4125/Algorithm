package etc.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 잃어버린괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        String[] split = s.split("-");
        int answer = 0;
        for (int i = 0; i < split.length; i++) {
            int temp = sum(split[i]);
            if (i == 0) {
                answer += temp;
            } else {
                answer -= temp;
            }
        }
        System.out.println(answer);
    }

    private static int sum(String a) {
        int sum = 0;
        String[] split = a.split("\\+");
        for (String s : split) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }
}
