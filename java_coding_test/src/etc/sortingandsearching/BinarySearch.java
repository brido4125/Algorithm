package etc.sortingandsearching;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int target = sc.nextInt();
        int[] ary = new int[num];
        for (int i = 0; i < ary.length; i++) {
            ary[i] = sc.nextInt();
        }
        System.out.println(solution(target, ary));

    }

    private static int solution(int target, int[] ary) {
        Arrays.sort(ary);
        int lt = 0;
        int rt = ary.length - 1;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (target == ary[mid]) {
                return mid + 1;
            } else if (target < ary[mid]) {
                rt = mid - 1;
            } else if (target > ary[mid]) {
                lt = mid + 1;
            }
        }
        return -1;
    }

}
