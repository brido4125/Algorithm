package study.brido;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 직각삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < 3; i++) {
                pq.add(Integer.parseInt(st.nextToken()));
            }
            double x = Math.pow(pq.poll(), 2);
            double y = Math.pow(pq.poll(), 2);
            double z = Math.pow(pq.poll(), 2);

            if (x == 0) {
                break;
            }

            if (x + y == z) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }

    }
}
