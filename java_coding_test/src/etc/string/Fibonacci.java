package etc.string;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {
    private static int[] solution(int n) {
        int[] answer = new int[n];
        setFibonacciFormat(answer);
        for (int i = 2; i < answer.length; i++) {
            answer[i] = answer[i - 1] + answer[i - 2];
        }
        return answer;
    }

    private static void setFibonacciFormat(int[] ary) {
        for (int i = 0; i <= 1; i++) {
            ary[i] = 1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Arrays.toString(solution(n)) = " + Arrays.toString(solution(n)));
    }
}
