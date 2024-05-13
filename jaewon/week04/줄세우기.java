import java.io.*;
import java.util.*;

public class Main {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    List<Integer> students = new LinkedList<>();

    private int sort() {
        int cnt = 0;

        for (int i = 1; i < 20; ++i) {
            for (int k = i - 1; k >= 0; --k) {
                if (students.get(k) > students.get(i)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private void sol() throws Exception {
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            students.clear();
            String[] tokens = br.readLine().split(" ");
            for (int i = 1; i <= 20; ++i) {
                students.add(Integer.parseInt(tokens[i]));
            }
            bw.append(tokens[0] + " " + String.valueOf(sort()) + "\n");
        }

        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
