package array;

import java.util.Arrays;
import java.util.Scanner;

public class GetRank {
    private static final int MIN_INTEGER = Integer.MIN_VALUE;

    private static int[] solution(int num, int[] ary) {
        int[] answer = new int[num];
        int rank = 1;
        boolean flag = zeroElementFlag(answer);
        /*
        * answer에 0이 있으면 Loop 돌아야함
        * */
        while (!flag) {
            int max = getMaxScore(ary);
            int count = 0;
            for (int i = 0; i < answer.length; i++) {
                if (max == ary[i]) {
                    answer[i] = rank;
                    count++;
                    ary[i] = MIN_INTEGER;
                }
                flag = zeroElementFlag(answer);
            }
            rank += count;
        }
        return answer;
    }
    //false => 0이 존재
    private static boolean zeroElementFlag(int[] ary) {
        boolean answer = true;
        for (int j : ary) {
            if (j == 0) {
                answer = false;
                break;
            }
        }
        return answer;
    }
    private static int getMaxScore(int[] ary) {
        int max = ary[0];
        for (int i = 1; i < ary.length; i++) {
            if (max < ary[i]) {
                max = ary[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] ary = new int[num];
        for (int i = 0; i < ary.length; i++) {
            ary[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(solution(num, ary)));
    }
}
