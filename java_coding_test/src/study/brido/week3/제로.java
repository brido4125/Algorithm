package study.brido.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 제로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if (num != 0) {
                stk.push(num);
            } else {
                stk.pop();
            }
        }
        System.out.println(stk.stream().reduce((a,b) -> a + b).orElse(0));
    }
}
