package study.brido.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 과일탕후루 {

    static Integer answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] per = new int[2];

        Deque<Integer> src = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            src.add(Integer.parseInt(st.nextToken()));
        }
        permutation(0, per, N, src);
        System.out.println(answer);
    }

    // 중복 순열
    static void permutation(int L, int[] per, int N, Deque<Integer> deque) {
        if (L == 2) {
            ArrayDeque<Integer> copy = new ArrayDeque<>(deque);
            int firstPoll = per[0];
            int lastPoll = per[1];

            for (int i = 0; i < firstPoll; i++) {
                copy.pollFirst();
            }

            for (int i = 0; i < lastPoll; i++) {
                copy.pollLast();
            }

            if (new HashSet<>(copy).size() <= 2 && copy.size() >= answer ) {
                answer = copy.size();
            }
            return;
        }
        for (int i = 0 ; i < N ; i++) {
            per[L] = i;
            permutation(L + 1, per, N, deque);
        }
    }
}
