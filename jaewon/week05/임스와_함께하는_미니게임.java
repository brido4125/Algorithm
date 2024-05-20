import java.io.*;
import java.util.*;

public class Main {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void sol() throws Exception {
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = br.readLine().split(" ");

        int N = Integer.parseInt(tokens[0]);
        char game = tokens[1].charAt(0);

        Set<String> names = new HashSet<>();
        for (int i = 0; i < N; ++i) {
            String name = br.readLine();
            names.add(name);
        }

        int res = names.size();
        if (game == 'F') {
            res /= 2;
        } else if (game == 'O') {
            res /= 3;
        }
        bw.append(res + "\n");

        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
