package study.brido.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 줄세우기 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int testNum = Integer.parseInt(st.nextToken());
      int count = 0;

      List<Integer> numbers = new ArrayList<>();
      for (int j = 0; j < 20; j++) {
        int target = Integer.parseInt(st.nextToken());
        boolean flag = false;

        for (int k = 0 ; k < numbers.size(); k++) {
          if (numbers.get(k) > target) {
            count += (numbers.size() - k);
            numbers.add(k, target);
            flag = true;
            break;
          }
        }
        if (!flag) {
          numbers.add(target);
        }
      }
      System.out.println(testNum + " " + count);
    }
  }
}
