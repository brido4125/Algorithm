package study.brido.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class 나이순정렬 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        List<Entry<Integer, String>> lists = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            lists.add(Map.entry(age, name));
        }
        lists.sort((o1, o2) -> {
            Integer key1 = o1.getKey();
            Integer key2 = o2.getKey();
            if (key1 > key2) {
                return 1;
            } else if (key1 < key2){
                return -1;
            }
            return 0;
        });
        lists.forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));
    }
}
