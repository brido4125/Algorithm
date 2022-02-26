package tpAndSw;

import java.util.Scanner;

public class MaxSales {
    private static int solution(int num, int days, int[] ary) {
        int answer;
        int sum = 0;
        for (int i = 0; i < days; i++) {
            sum += ary[i];
        }
        answer = sum;
        for (int i = days; i < num; i++) {
            sum += (ary[i] - ary[i - days]);
            answer = Math.max(answer, sum);
        }
        return answer;
    }

    private static int solution2(int num, int days, int[] ary) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int index = 0;
        while (index < ary.length - days) {
            for (int i = 0; i < days; i++) {
                sum += ary[index + i];
            }
            if (max < sum) {
                max = sum;
            }
            sum = 0;
            index++;
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int days = sc.nextInt();
        int[] ary = new int[num];
        for (int i = 0; i < ary.length; i++) {
            ary[i] = sc.nextInt();
        }
        System.out.println(solution(num,days,ary));
    }
}
