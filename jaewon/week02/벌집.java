import java.io.*;

public class Main {

    private void sol() throws Exception {
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int n = 1, i = 1;
        while (n < num) {
            n += 6 * i;
            ++i;
        }

        System.out.println(i);
    }

    public static void main(String[] args) throws Exception {
        new Main().sol();
    }

}
