package etc.array;

import java.util.Scanner;

public class PrimeNumber {
    private static int timeLimitSolution(int num) {
        int answer = 0;
        for (int i = 2; i <= num; i++) {
            int count = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count == 1) {
                answer++;
            }
        }
        return answer;
    }
    private static int solution(int num) {
        int answer = 0;
        int[] ary = new int[num + 1];
        for (int i = 2; i < ary.length; i++) {
            if (ary[i] == 0) {
                answer++;
                for (int j = i; j <= num; j=j+i) {//j는 i만큼 증가 필요
                    ary[j] = 1;
                }
            }
        }
        return answer;
    }


        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        System.out.println(solution(i));
    }
}
