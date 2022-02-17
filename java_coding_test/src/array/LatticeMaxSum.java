package array;

import java.util.Scanner;

public class LatticeMaxSum {
    private static int solution(int num, int[][] ary) {
        int answer = Integer.MIN_VALUE;
        int rowSum;//행의 합
        int columnSum;//열의 합
        for (int i = 0; i < ary.length; i++) {
            rowSum = 0;
            columnSum = 0;
            for (int j = 0; j < ary[i].length; j++) {
                rowSum += ary[i][j];//Sum of Rows
                columnSum += ary[j][i];//Sum of Columns
            }
            answer = Math.max(answer, rowSum);
            answer = Math.max(answer, columnSum);
        }
        int maxDiagonal = getDiagonalSum(ary);
        return answer = Math.max(answer, maxDiagonal);
    }

    //행렬에서 대각선의 합 구하기
    private static int getDiagonalSum(int[][] ary) {
        int rightDiagonalSum = 0;
        int leftDiagonalSum = 0;

        for (int i = 0; i < ary.length; i++) {
            rightDiagonalSum += ary[i][i];
            leftDiagonalSum += ary[i][ary.length - i - 1];
        }
        return Math.max(rightDiagonalSum, leftDiagonalSum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] ary = new int[num][num];
        for (int i = 0; i < ary.length; i++) {
            for (int j = 0; j < ary[0].length; j++) {
                ary[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(num, ary));
    }
}
