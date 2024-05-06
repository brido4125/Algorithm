import java.io.*;
import java.util.*;

public class Main {
    int[] counts = new int[26];

    private void sol() throws Exception {
        //System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        System.out.println(k % 2 == 1 ? "SK" : "CY");
    }

    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
