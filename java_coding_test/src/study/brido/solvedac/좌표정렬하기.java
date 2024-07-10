package study.brido.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class 좌표정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        List<Entry<Integer, Integer>> lists = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            lists.add(Map.entry(x, y));
        }

        lists.sort((e1, e2) -> {
            if (e1.getKey() > e2.getKey()) {
                return 1;
            } else if (e1.getKey() < e2.getKey()) {
                return -1;
            } else {
                return e1.getValue() >= e2.getValue() ? 1 : -1;
            }
        });

        lists.forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));
    }
}
