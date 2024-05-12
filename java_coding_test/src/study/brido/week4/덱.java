package study.brido.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 덱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            if (st.countTokens() == 2) {
                String s = st.nextToken();
                int n = Integer.parseInt(st.nextToken());
                if (s.equals("push_back")) {
                    deque.add(n);
                } else if (s.equals("push_front")) {
                    deque.addFirst(n);
                }
            } else {
                String s = st.nextToken();
                if (s.equals("pop_front")) {
                    if (deque.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(deque.pollFirst() + "\n");
                    }
                } else if (s.equals("pop_back")) {
                    if (deque.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(deque.pollLast() + "\n");
                    }
                } else if (s.equals("size")) {
                    sb.append(deque.size() + "\n");
                } else if (s.equals("empty")) {
                    if (deque.isEmpty()) {
                        sb.append(1 + "\n");
                    } else {
                        sb.append(0 + "\n");
                    }
                } else if (s.equals("front")) {
                    if (deque.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(deque.peekFirst() + "\n");
                    }
                } else if (s.equals("back")) {
                    if (deque.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(deque.peekLast() + "\n");
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }
}
