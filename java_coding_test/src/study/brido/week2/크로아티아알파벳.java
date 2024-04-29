package study.brido.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class 크로아티아알파벳 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String target = st.nextToken();

        List<String> strings = List.of("dz=", "c=", "c-", "d-", "lj", "nj", "s=", "z=");
        int count = 0;
        while (containsAny(target, strings)) {
            for (String s : strings) {
                String remove = target.replace(s, "!");
                target = remove;
            }
        }
        count += target.length();
        System.out.println(count);
    }

    private static boolean containsAny(String target, List<String> strings) {
        int cnt = 0;
        for (String s : strings) {
            if (target.contains(s)) {
                cnt += 1;
            }
        }
        return cnt > 0;
    }
}
