package study.brido.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 덩치 {

    private static class Dungchi {
        int x;
        int y;

        public Dungchi(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        List<Dungchi> dungchiList = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            dungchiList.add(new Dungchi(x, y));
        }

        List<Integer> answer = new ArrayList<>();

        int bigger = 0;
        for (Dungchi d1 : dungchiList) {
            for (Dungchi d2 : dungchiList) {
                if (d1.x < d2.x && d1.y < d2.y) {
                    bigger += 1;
                }
            }
            answer.add(bigger);
            bigger = 0;
        }
        System.out.println(answer.stream().map(i -> (i + 1) + " ").collect(Collectors.joining()));
    }
}
