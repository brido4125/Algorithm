package array;

import java.util.Scanner;

public class VisibleStudent {
    public static int solution(int n, int [] ints) {
        int answer = 1;
        int max = ints[0];
        for (int height:ints) {
            if (max < height) {
                max = height;
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = sc.nextInt();
        }
        System.out.println("solution(n,ints) = " + solution(n,ints));

    }
}
