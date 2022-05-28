package dp;

import java.util.Scanner;

public class UpStair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(solution(N));
    }

    private static int solution(int n) {
        int[] dy = new int[n+1];
        dy[1] = 1;
        dy[2] = 2;
        for (int i = 3; i < dy.length; i++) {
            dy[i] = dy[i - 2] + dy[i - 1];
        }
        return dy[n];
    }
}
