package tpAndSw;

import java.util.Scanner;

public class MaxSerial {
    private static int solution(int n, int k, int[] arr) {
        int anwser = 0;
        int cnt = 0;
        int lt = 0;
        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) {
                cnt++;
            }
            while (cnt > k) {
                if (arr[lt] == 0) {
                    cnt--;
                }
                lt++;
            }
            anwser = Math.max(anwser, rt - lt + 1);
        }
        return anwser;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
    }
}
