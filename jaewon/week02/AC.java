import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    String cmd;
    int len;
    ArrayDeque<Integer> deque = new ArrayDeque<>();
    StringBuilder sb = new StringBuilder();

    private void sol() throws Exception {
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            cmd = br.readLine();
            len = Integer.parseInt(br.readLine());

            var st = new StringTokenizer(br.readLine(), "[],");

            while (st.hasMoreTokens()) {
                deque.add(Integer.parseInt(st.nextToken()));
            }
            process();
        }
        System.out.print(sb.toString());
    }

    private void process() {
        boolean isAsc = true;

        for (char ch : cmd.toCharArray()) {
            if (ch == 'R') {
                isAsc = !isAsc;
                continue;
            }
            // 'D'
            if (deque.isEmpty()) {
                sb.append("error\n");
                return;
            }
            if (isAsc) {
                deque.pollFirst();
            } else {
                deque.pollLast();
            }
        }

        if (deque.isEmpty()) {
            sb.append("[]\n");
            return;
        }

        sb.append("[");
        if (isAsc) {
            sb.append(deque.pollFirst());
            while (!deque.isEmpty()) {
                sb.append(',').append(deque.pollFirst());
            }
        } else {
            sb.append(deque.pollLast());
            while (!deque.isEmpty()) {
                sb.append(',').append(deque.pollLast());
            }
        }
        sb.append("]\n");
    }

    public static void main(String[] args) throws Exception {
        new Main().sol();
    }

}
