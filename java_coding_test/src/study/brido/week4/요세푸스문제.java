package study.brido.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 요세푸스문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        int cnt = 1;
        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            if (cnt == K) {
                cnt = 1;
                list.add(queue.poll());
            } else {
                cnt += 1;
                queue.add(queue.poll());
            }
        }
        System.out.print("<");
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                System.out.print(list.get(i) + ">");
            } else {
                System.out.print(list.get(i) + ", ");
            }
        }
    }
}
