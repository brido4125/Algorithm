package study.brido.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 올림픽 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] kScore = null;
    List<int[]> numList = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int num = Integer.parseInt(st.nextToken());

      int gold = Integer.parseInt(st.nextToken());
      int silver = Integer.parseInt(st.nextToken());
      int bronze = Integer.parseInt(st.nextToken());

      if (num == K) {
        kScore = new int[]{gold, silver, bronze};
      } else {
        numList.add(new int[]{gold, silver, bronze});
      }
    }

    int[] cmp = Arrays.copyOf(kScore, 3);
    long count = numList.stream().filter(ary -> {
      if (ary[0] > cmp[0]) {
        return true;
      }
      if (ary[0] == cmp[0] && ary[1] > cmp[1]) {
        return true;
      }
      if (ary[0] == cmp[0] && ary[1] == cmp[1] && ary[2] > cmp[2]) {
        return true;
      }
      return false;
    }).count();
    long answer = count + 1;

    System.out.println(answer);
  }
}
