package study.brido.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 단어공부 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        String upperCase = s.toUpperCase();
        char[] charArray = upperCase.toCharArray();
        HashMap<Character, Long> map = new HashMap<>();

        long max = 0;

        for (Character c : charArray) {
            map.put(c, map.getOrDefault(c, 0L) + 1);
            if(max < map.get(c)) {
                max = map.get(c);
            }
        }

        int cnt = 0;
        Character c = null;
        for (Map.Entry<Character, Long> e : map.entrySet()) {
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
