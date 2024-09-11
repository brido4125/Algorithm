package study.brido.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주몽 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int M = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());

    int[] ary = new int[N];
    for (int i = 0; i < N; i++) {
      ary[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(ary);

    // 1 2 3 4 5 7

    int start = 0;
    int end = N - 1;

    int answer = 0;
    while (start < end) {
      if (ary[start] + ary[end] == M) {
        answer += 1;
        end--;
      } else if (ary[start] + ary[end] < M) {
        start++;
      } else if (ary[start] + ary[end] > M) {
        end--;
      }
    }

    System.out.println(answer);
  }
}
