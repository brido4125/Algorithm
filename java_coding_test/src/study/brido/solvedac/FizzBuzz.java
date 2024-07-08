package study.brido.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FizzBuzz {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = new String[3];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            strs[i] = st.nextToken();
        }

        int idx = 0;
        for (int i = 0 ; i < strs.length; i++) {
            if (strs[i].contains("zz")) {
                continue;
            }
            idx = i;
        }
        int answer;
        if (idx == 0) {
            answer = Integer.parseInt(strs[idx]) + 3;
        } else if (idx == 1) {
            answer = Integer.parseInt(strs[idx]) + 2;
        } else {
            answer = Integer.parseInt(strs[idx]) + 1;
        }

        if (answer % 3 == 0 && answer % 5 != 0) {
            System.out.println("Fizz");
        } else if (answer % 3 != 0 && answer % 5 == 0) {
            System.out.println("Buzz");
        }  else if (answer % 3 == 0) {
            System.out.println("FizzBuzz");
        } else {
            System.out.println(answer);
        }

    }
}
