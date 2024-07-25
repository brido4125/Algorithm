package study.brido.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());
            if (target == 0) {
                if (queue.isEmpty()) {
                    sb.append("0\n");
                } else {
                    Integer poll = queue.poll();
                    sb.append(poll).append("\n");
                }
            } else {
                queue.add(target);
            }
        }

        System.out.println(sb);
    }
}
