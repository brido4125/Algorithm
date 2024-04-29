package study.brido.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 단어공부 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        String lowerCase = s.toLowerCase();
        char[] charArray = lowerCase.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : charArray) {
            if (map.get(c) == null) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        Integer max = map.values().stream().max(Comparator.naturalOrder()).get();
        int cnt = 0;
        Character c = null;
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() == max) {
                cnt += 1;
                c = e.getKey();
            }
        }
        if (cnt > 1) {
            System.out.println("?");
        } else {
            System.out.println(c.toString().toUpperCase());
        }
    }
}
