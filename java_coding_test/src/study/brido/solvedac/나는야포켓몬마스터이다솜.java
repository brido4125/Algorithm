package study.brido.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 나는야포켓몬마스터이다솜 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, String> dogam = new HashMap<>();
        Map<String, Integer> dogam2 = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            dogam.put(i, s);
            dogam2.put(s, i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            try {
                int number = Integer.parseInt(s);
                sb.append(dogam.get(number) + "\n");
            } catch (NumberFormatException e) {
                sb.append(dogam2.get(s) + "\n");
            }
        }
        System.out.println(sb);
    }
}
