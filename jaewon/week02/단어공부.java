import java.io.*;
import java.util.*;

public class Main {
    int[] counts = new int[26];

    private void sol() throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        Arrays.fill(counts, 0);

        for (char ch : line.toCharArray()) {
            if (Character.isUpperCase(ch))
                counts[ch - 'A']++;
            else
                counts[ch - 'a']++;
        }

        int maxIdx = 0;
        int maxV = -1;
        for (int i = 0; i < counts.length; ++i) {
            if (maxV < counts[i])
                maxV = counts[i];
        }

        boolean foundMax = false;
        for (int i = 0; i < counts.length; ++i) {
            if (maxV == counts[i]) {
                if (foundMax) {
                    System.out.println("?");
                    return;
                }
                foundMax = true;
                maxIdx = i;
            } else if (maxV < counts[i]) {
                maxIdx = i;
                maxV = counts[i];
            }
        }
        System.out.println((char) (maxIdx + 'A'));
    }

    public static void main(String[] args) throws Exception {
        new Main().sol();
    }

}
