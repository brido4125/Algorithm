package etc.array;

import java.util.Scanner;

public class CalculatePoint {
    private static int solution(int num, int[] ary) {
        int answer = 0;
        int sum = 0;

        for (int j : ary) {
            if (j == 1) {
                sum++;
            } else {
                sum = 0;
            }
            answer += sum;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("solution(num,arr) = " + solution(num, arr));
    }
}
