package array;

import java.util.Scanner;

public class ClassLeader {
    private static int solution(int num, int[][] ary) {
        int answer = 0;
        int minValue = Integer.MIN_VALUE;
        for (int i = 1; i <= num; i++) {
            int cnt = 0;
            for (int j = 1; j <= num; j++) {
                for (int k = 1; k < 6; k++) {
                    if (ary[i][k] == ary[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if (cnt > minValue) {
                minValue = cnt;
                answer = i;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] ary = new int[num + 1][6];
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j < 6; j++) {
                ary[i][j] = sc.nextInt();
            }
        }
        solution(num, ary);
    }
}
