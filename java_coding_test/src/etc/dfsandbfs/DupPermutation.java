package etc.dfsandbfs;

import java.util.Scanner;

public class DupPermutation {
    static int N,M;
    static int[] permutation;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        permutation = new int[M];//M개 만큼 숫자를 뽑아서 배열에 저장 후 출력
        dfs(0);
    }

    private static void dfs(int L) {
        if (L == M) {
            for (int x : permutation) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            //1부터 N까지 수를 선택
            for (int i = 1; i <= N; i++) {
                permutation[L] = i; // 첫번째로 뽑은 수를 index 0에 위치 ex) i가 1이면 제일 처음으로 1뽑음
                dfs(L + 1);//무조건 그 다음 Level로
            }
        }
    }
}
