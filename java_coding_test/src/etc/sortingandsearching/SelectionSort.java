package etc.sortingandsearching;

import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] ary = new int[size];
        for (int i = 0; i < size; i++) {
            ary[i] = sc.nextInt();
        }
        solution(size, ary);
        for (int j : ary) {
            System.out.print(j + " ");
        }
    }

    private static void solution(int size, int[] ary) {
        for (int i = 0; i < ary.length; i++) {
            for (int j = i + 1; j < ary.length; j++) {
                int tmp;
                if (ary[i] > ary[j]) {
                    tmp = ary[i];
                    ary[i] = ary[j];
                    ary[j] = tmp;
                }
            }
        }
    }
}
