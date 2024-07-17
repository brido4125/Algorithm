package study.brido.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 듣보잡 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    Map<String, Boolean> map = new HashMap<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      map.put(st.nextToken(), true);
    }

    List<String> answer = new ArrayList<>();

    int count = 0;
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      String target = st.nextToken();
      if (map.get(target) != null && map.get(target)) {
        answer.add(target);
        count += 1;
      }
    }
    System.out.println(count);
    Collections.sort(answer);
    answer.forEach(System.out::println);

  }
}
