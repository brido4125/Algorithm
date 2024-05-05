package study.brido.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 집합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            if (st.countTokens() == 2) {
                String op = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                switch (op) {
                    case "add":
                        set.add(num);
                        break;
                    case "check":
                        if (set.contains(num)) {
                            sb.append(1 + "\n");
                        } else {
                            sb.append(0 + "\n");
                        }
                        break;
                    case "remove":
                        set.remove(num);
                        break;
                    case "toggle":
                        if (set.contains(num)) {
                            set.remove(num);
                        } else {
                            set.add(num);
                        }
                        break;
                    default:
                        break;
                }
            } else {
                String op = st.nextToken();
                switch (op) {
                    case "all":
                        set.clear();
                        for (int j = 1; j <= 20; j++) {
                            set.add(j);
                        }
                        break;
                    case "empty":
                        set.clear();
                        break;
                    default:
                        break;
                }
            }
        }
        System.out.println(sb.toString());
    }
}
