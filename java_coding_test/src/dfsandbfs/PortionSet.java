package dfsandbfs;

import java.util.Scanner;

public class PortionSet {
    static String answer = "NO";
    static int n, total = 0;
    static boolean flag = false;


    private static void DFS(int L, int sum, int[] ary) {
        if (flag) {
            return;
        }
        if (sum > total / 2) {
            return;
        }
        //n == 원소의 갯수, L이 6이되면 리프노드 도달
        if (L == n) {
            if ((total - sum) == sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            DFS(L + 1, sum + ary[L], ary);
            DFS(L + 1, sum, ary);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int []ary = new int[num];
        for (int i = 0; i < ary.length; i++) {
            ary[i] = sc.nextInt();
        }
        System.out.println(solution(ary));
    }

    private static String solution(int[] ary) {
        DFS(0, 0, ary);
        return answer;
    }


}
