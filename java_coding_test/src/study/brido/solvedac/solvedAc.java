package study.brido.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class solvedAc {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        if (N == 0) {
            System.out.println(0);
            return;
        }

        double per = (double) (N * 15) / 100;
        long round = Math.round(per);

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        double asDouble = list.subList((int) round, (int) (list.size() - round))
            .stream().mapToInt(a -> a)
            .average().getAsDouble();
        System.out.println(Math.round(asDouble));

    }
}
