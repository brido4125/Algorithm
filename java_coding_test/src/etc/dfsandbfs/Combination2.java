package etc.dfsandbfs;

import java.util.Scanner;

public class Combination2 {
    static int N;
    static int M;
    static int[] values;
    static int[] check;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();//1부터 N까지
        M = sc.nextInt();
        solution(N, M);
    }

    private static void solution(int n, int m) {
        values = new int[m];
        check = new int[N + 1];
        dfs(0,1);
    }

    /*
    * startIndex 설정하기
    * */
    private static void dfs(int L,int startIndex) {
        if (L == M) {
            for (int value : values) {
                System.out.print(value + " ");
            }
            System.out.println();
        } else {
            for (int i = startIndex; i <= N; i++) {
                if (check[i] == 0) {
                    check[i] = 1;
                    values[L] = i;
                    dfs(L + 1,i+1);
                    check[i] = 0;
                }
            }
        }
    }
}
