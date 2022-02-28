package tpAndSw;

import java.util.*;

public class SerialSum {
    private static int solution(int length, int num, int[] ary) {
        int anwser = 0;
        int leftPointer = 0;
        int rightPointer = 0;
        int sum = 0;
        for (rightPointer = 0; rightPointer < length; rightPointer++) {
            sum += ary[rightPointer];
            if (sum == num) {
                anwser++;
            }
            while (sum >= num) {
                sum -= ary[leftPointer];
                leftPointer++;
                if (sum == num) {
                    anwser++;
                }
            }
        }
        return anwser;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int sum = sc.nextInt();
        int[] ary = new int[length];
        for (int i = 0; i < ary.length; i++) {
            ary[i] = sc.nextInt();
        }
        System.out.println(solution(length, sum, ary));
    }
}
