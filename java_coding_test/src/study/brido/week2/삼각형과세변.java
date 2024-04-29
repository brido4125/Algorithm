package study.brido.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 삼각형과세변 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int[] list = new int[3];
            for (int i = 0; i < 3; i++) {
                int n = Integer.parseInt(st.nextToken());
                list[i] = n;
            }
            if (list[0] == 0) {
                return;
            }
            Arrays.sort(list);
            if (list[2] >= list[0] + list[1]) {
                System.out.println("Invalid");
            } else if (list[0] == list[2]) {
                System.out.println("Equilateral");
            } else if (list[0] == list[1] || list[1] == list[2]){
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }

        }
    }
}
