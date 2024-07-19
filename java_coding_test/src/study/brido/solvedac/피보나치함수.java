package study.brido.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* DP 기초
* */
public class 피보나치함수 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    StringBuilder sb = new StringBuilder();

    int[][] board = new int[41][2];

    board[0][0] = 1;
    board[0][1] = 0;

    board[1][0] = 0;
    board[1][1] = 1;

    for (int i = 2; i < board.length; i++) {
      board[i][0] = board[i - 1][0] + board[i - 2][0];
      board[i][1] = board[i - 1][1] + board[i - 2][1];
    }

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int target = Integer.parseInt(st.nextToken());
      sb.append(board[target][0]).append(" ").append(board[target][1]).append("\n");
    }
    System.out.println(sb);
  }
}
