package study.brido.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 웰컴키트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        List<Integer> sizeLists = new ArrayList<>();
        while (st.hasMoreTokens()) {
            sizeLists.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        int shirt = Integer.parseInt(st.nextToken());
        int pen = Integer.parseInt(st.nextToken());

        int sum = 0;

        for (Integer i : sizeLists) {
            if (i % shirt == 0) {
                sum += (i / shirt);
            } else {
                sum += ((i / shirt) + 1);
            }
        }

        System.out.println(sum);
        System.out.println((N / pen) + " " + (N % pen));
    }
}