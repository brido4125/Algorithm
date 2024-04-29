package study.brido.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class AC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            String p = st.nextToken();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            String ary = st.nextToken();
            List<Integer> intAry = toIntAry(ary, n);

            if (calc(intAry, p.toCharArray())) {
                sb.append("[");
                for (int j = 0 ; j < intAry.size(); j++) {
                    sb.append(intAry.get(j));
                    if (j < intAry.size() - 1) {
                        sb.append(",");
                    }
                }
                sb.append("]");
                sb.append("\n");
            } else {
                sb.append("error" + "\n");
            }
        }
        System.out.println(sb.toString());
    }

    private static List<Integer> toIntAry(String s, int size) {
        String s1 = s.replaceAll("\\[|\\]", "");
        String[] split = s1.split(",");
        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(Integer.parseInt(split[i]));
        }
        return list;
    }

    private static boolean calc(List<Integer> target, char[] p) {
        boolean reverse = false;
        for (Character c : p) {
            if (c.equals('R')) {
                if (reverse) {
                    reverse = false;
                } else {
                    reverse = true;
                }
            } else if (c.equals('D')) {
                if (target.isEmpty()) {
                    return false;
                }
                if (reverse) {
                    target.remove(target.size() - 1);
                } else {
                    target.remove(0);
                }
            }
        }
        if (reverse) {
            Collections.reverse(target);
        }
        return true;
    }
}
