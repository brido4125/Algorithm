package etc.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 수묶기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> positiveQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> negativeQ = new PriorityQueue<>();
        Queue<Integer> zeroQ = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Integer num = Integer.valueOf(st.nextToken());
            if (num > 0) {
                positiveQ.add(num);
            } else if (num == 0) {
                zeroQ.add(num);
            } else {
                negativeQ.add(num);
            }
        }

        int answer = 0;

        while (negativeQ.size() > 1) {
            int poll1 = negativeQ.poll();
            int poll2 = negativeQ.poll();
            answer += (poll1 * poll2);
        }

        while (!zeroQ.isEmpty() && !negativeQ.isEmpty()) {
            negativeQ.poll();
            zeroQ.poll();
        }

        while (!positiveQ.isEmpty()) {
            Integer peek = positiveQ.peek();
            if (peek == 1) {
                break;
            } else {
                Integer first = positiveQ.poll();
                if (positiveQ.peek() == null) {
                    answer += first;
                    break;
                } else if (positiveQ.peek() == 1) {
                    positiveQ.add(first);
                    break;
                } else {
                    Integer second = positiveQ.poll();
                    answer += (first * second);
                }
            }
        }
        while (!positiveQ.isEmpty()) {
            answer += positiveQ.poll();
        }
        while (!negativeQ.isEmpty()) {
            answer += negativeQ.poll();
        }
        System.out.println(answer);
    }
}
