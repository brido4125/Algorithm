import java.io.*;
import java.util.*;

public class Main {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void sol() throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int k = Integer.parseInt(tokens[1]);

        LinkedList<Integer> nums = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        bw.append('<');
        while (!nums.isEmpty()) {
            for (int i = 0; i < k; i++) {
                if (i == k - 1) { // 1번 사람 부터 시작하기 때문에 k-1 과 매치한다.
                    if (nums.size() == 1) { // 마지막 인원은 쉼표를 제외하고 넣어준다.
                        bw.append(nums.remove().toString());
                    } else {
                        bw.append(nums.remove() + ", ");
                    }
                } else {
                    nums.add(nums.remove());
                }
            }
        }
        bw.append('>');
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
