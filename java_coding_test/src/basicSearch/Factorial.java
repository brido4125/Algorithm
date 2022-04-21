package basicSearch;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        solution(N);
    }

    private static int solution(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * solution(n - 1);
        }
    }
}
