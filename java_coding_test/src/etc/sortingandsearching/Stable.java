package etc.sortingandsearching;

import java.util.Arrays;
import java.util.Scanner;

public class Stable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();
        int[] ary = new int[N];
        for (int i = 0; i < ary.length; i++) {
            ary[i] = sc.nextInt();
        }
        System.out.println(solution(C, ary));

    }

    private static int solution(int c, int[] ary) {
        int answer = 0;
        Arrays.sort(ary);
        int lt = 1;
        int rt = Arrays.stream(ary).max().getAsInt() - Arrays.stream(ary).min().getAsInt();
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (check(mid, ary) >= c) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        return answer;
    }

    private static int check(int mid, int[] ary) {
        int count = 1;
        int startPos = ary[0];
        for (int i = 1; i < ary.length; i++) {
            if (ary[i] - startPos >= mid) {
                count++;
                startPos = ary[i];
            }
        }
        return count;
    }
}
