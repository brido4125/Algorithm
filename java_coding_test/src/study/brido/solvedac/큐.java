package study.brido.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            if (st.countTokens() == 1) {
                String s = st.nextToken();
                if (s.equals("empty")) {
                    if (queue.isEmpty()) {
                        System.out.println("1");
                    } else {
                        System.out.println("0");
                    }
                } else if (s.equals("size")) {
                    System.out.println(queue.size());
                } else {
                    if (queue.isEmpty()) {
                        System.out.println(-1);
                    } else if (s.equals("front")) {
                        System.out.println(queue.peekFirst());
                    } else if (s.equals("back")) {
                        System.out.println(queue.peekLast());
                    } else if (s.equals("pop")) {
                        System.out.println(queue.pop());
                    }
                }

            } else {
                st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                queue.add(num);
            }
        }
    }
}
