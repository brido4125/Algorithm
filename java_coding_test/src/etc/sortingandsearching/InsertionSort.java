package etc.sortingandsearching;

import java.util.Scanner;



public class InsertionSort {
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
        for (int i = 1; i < size; i++) {
            int tmp = ary[i];
            int j;
            for (j= i - 1; j >= 0; j--) {
                if (ary[j] > tmp) {
                    ary[j + 1] = ary[j];
                } else {
                    break;
                }
            }
            ary[j + 1] = tmp;
        }
    }
}
