import java.io.*;
import java.util.*;

public class Main {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void sol() throws Exception {
        //System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        int data = 0;
        while (k-- > 0) {
            String[] tokens = br.readLine().split(" ");
            String cmd = tokens[0];
            int num = 0;
            if (tokens.length > 1) {
                num = Integer.parseInt(tokens[1]);
            }

            switch (cmd) {
                case "add":
                    data |= (1 << num);
                    break;
                case "remove":
                    data &= ~(1 << num);
                    break;
                case "check":
                    bw.write((data >> num & 1) == 1 ? "1\n" : "0\n");
                    break;
                case "toggle":
                    data ^= (1 << num);
                    break;
                case "all":
                    data = Integer.MAX_VALUE;
                    break;
                case "empty":
                    data = 0;
                    break;
                default:
                    break;
            }
        }
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
