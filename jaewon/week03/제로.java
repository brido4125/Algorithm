import java.io.*;
import java.util.*;

public class Main {
    int[] counts = new int[26];

    private void sol() throws Exception {
        //System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<>();

        while (k-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                st.pop();
            } else {
                st.add(num);
            }
        }

        int sum = 0;
        while (!st.isEmpty()) {
            sum += st.pop();
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
