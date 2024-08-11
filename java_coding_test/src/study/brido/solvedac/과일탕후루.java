package study.brido.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 과일탕후루 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] ary = new int[N];
        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(st.nextToken());
            ary[i] = t;
            Integer v = map.putIfAbsent(t, 1);
            if (v != null) {
                map.put(t, v + 1);
            }
        }

        // 크기가 i인 sliding window
        for (int i = N; i >= 2; i--) {
            if (map.size() <= 2) {
                System.out.println(i);
                return;
            }

            for (int start = 0; start < N - i; start++) {
                int end  = start + i;
                Integer startElem = map.get(ary[start]);
                map.put(ary[start], startElem - 1);
                if (map.get(ary[start]) == 0) {
                    map.remove(ary[start]);
                }

                Integer endElem = map.putIfAbsent(ary[end], 1);
                if (endElem != null) {
                    map.put(ary[end], endElem + 1);
                }

                if (map.size() <= 2) {
                    System.out.println(i);
                    return;
                }
            }
        }
    }
}
