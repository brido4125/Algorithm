package sortingandsearching;

import java.util.*;

public class MusicVideo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] ary = new int[N];
        for (int i = 0; i < ary.length; i++) {
            ary[i] = sc.nextInt();
        }
        System.out.println(solution(N, M, ary));
    }

    private static int solution(int n, int m, int[] ary) {
        int answer = 0;
        //M 덩이로 나눠야함
        int lt = Arrays.stream(ary).max().orElseThrow();
        int rt = Arrays.stream(ary).sum();
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (checkSize(mid,ary) <= m) {
                rt = mid - 1;
                answer = mid;
            } else {
                lt = mid + 1;
            }
        }
        return answer;
    }

    private static int checkSize(int mid, int[] ary) {
        int chunk = 1; //덩어리 수, 기본으로 CD 당연히 1개 존재
        int sum = 0;
        for (int x : ary) {
            if (sum + x > mid) {
                chunk++;
                sum = x;
            } else {
                sum += x;
            }
        }
        return chunk;
    }
}
