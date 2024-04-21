package etc.sortingandsearching;

import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] ary = new int[size];
        for (int i = 0; i < size-1; i++) {
            ary[i] = sc.nextInt();
        }
        solution(size, ary);
        for (int j : ary) {
            System.out.print(j + " ");
        }
    }

    private static void solution(int size, int[] ary) {
        for (int i = 0; i < ary.length; i++) {
            for (int j = 1; j < ary.length; j++) {
                if (ary[j-1] > ary[j]) {
                    int tmp = ary[j - 1];
                    ary[j - 1] = ary[j];
                    ary[j] = tmp;
                }
            }
        }
    }
}
