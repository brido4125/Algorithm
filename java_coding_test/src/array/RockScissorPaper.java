package array;

import java.util.Arrays;
import java.util.Scanner;

public class RockScissorPaper {
    private static String solution(int n, int[] a, int[] b) {
        char[] result = new char[n];
        for (int i = 0; i < n; i++) {
            if (a[i] == b[i]) {
                result[i] = 'D';
            } else if (a[i] == 2 && b[i] == 1) {
                result[i] = 'A';
            } else if (a[i] == 3 && b[i] == 2) {
                result[i] = 'A';
            } else if (a[i] == 1 && b[i] == 3) {
                result[i] = 'A';
            } else {
                result[i] = 'B';
            }
        }
        return Arrays.toString(result);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int[] a = new int[i];
        int[] b = new int[i];
        for (int j = 0; j < a.length; j++) {
            a[j] = sc.nextInt();
        }
        for (int j = 0; j < b.length; j++) {
            b[j] = sc.nextInt();
        }
        System.out.println("solution(i,a,b) = " + solution(i,a,b));
    }
}
