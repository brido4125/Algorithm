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

        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(st.nextToken());
            ary[i] = t;
        }

        int answer = 0;

        int start = 0;
        int end = 0;

        Map<Integer, Integer> map = new HashMap<>();

        while (end < N) {
            map.merge(ary[end], 1, Integer::sum);

            while (map.size() > 2) {
                map.put(ary[start], map.get(ary[start]) - 1);
                if (map.get(ary[start]) == 0) {
                    map.remove(ary[start]);
                }
                start++;
            }
            answer = Math.max(answer, end - start + 1);
            end++;
        }

        System.out.println(answer);
    }
}
