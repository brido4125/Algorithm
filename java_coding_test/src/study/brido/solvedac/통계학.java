package study.brido.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class 통계학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
            if (count.get(num) == null) {
                count.put(num, 0);
            } else {
                count.put(num, count.get(num) + 1);
            }
        }

        Collections.sort(list);

        double avg = list.stream()
            .mapToInt(i -> i)
            .average()
            .getAsDouble();

        ArrayList<Entry<Integer, Integer>> entries = new ArrayList<>(count.entrySet());

        Entry<Integer, Integer> max = Collections.max(entries, Comparator.comparingInt(Entry::getValue));
        ArrayList<Entry<Integer, Integer>> maxList = new ArrayList<>();
        for (Entry<Integer, Integer> e : entries) {
            if (e.getValue().equals(max.getValue())) {
                maxList.add(e);
            }
        }

        maxList.sort(Comparator.comparingInt(Entry::getKey));
        int center = N / 2;
        System.out.println(Math.round(avg));
        System.out.println(list.get(center));
        System.out.println(maxList.size() > 1 ? maxList.get(1).getKey() : maxList.get(0).getKey());
        System.out.println(list.get(N - 1) - list.get(0));
    }
}
