package study.brido.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class 과일탕후루 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        Deque<Integer> src = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            src.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> answers = new ArrayList<>();

        ArrayDeque<Integer> deque = new ArrayDeque<>(src);
        HashSet<Integer> set = new HashSet<>(deque);
        while (set.size() > 2) {
            Integer i = deque.pollFirst();
            if (!deque.contains(i)) {
                set.remove(i);
            }
            if (set.size() <= 2) {
                break;
            }
            Integer l = deque.pollLast();
            if (!deque.contains(l)) {
                set.remove(l);
            }
        }
        answers.add(deque.size());

        deque = new ArrayDeque<>(src);
        set = new HashSet<>(deque);
        while (set.size() > 2) {
            Integer i = deque.pollFirst();
            if (!deque.contains(i)) {
                set.remove(i);
            }
        }
        answers.add(deque.size());

        deque = new ArrayDeque<>(src);
        set = new HashSet<>(deque);
        while (set.size() > 2) {
            Integer i = deque.pollLast();
            if (!deque.contains(i)) {
                set.remove(i);
            }
        }
        answers.add(deque.size());

        deque = new ArrayDeque<>(src);
        set = new HashSet<>(deque);
        while (set.size() > 2) {
            Integer i = deque.pollLast();
            if (!deque.contains(i)) {
                set.remove(i);
            }
            if (set.size() <= 2) {
                break;
            }
            Integer l = deque.pollFirst();
            if (!deque.contains(l)) {
                set.remove(l);
            }
        }
        answers.add(deque.size());

        System.out.println(Collections.max(answers));
    }
}
