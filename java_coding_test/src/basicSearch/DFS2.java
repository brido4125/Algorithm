package basicSearch;

import java.util.List;
import java.util.Scanner;

/*
* DFS로 공집합을 제외한 부분집합 구하기
* */
public class DFS2 {
    static int[] ch;
    static int n;
    private static void dfs(int l) {

        if (l == n + 1) {
            String tmp = "";
            for (int i = 1; i < ch.length; i++) {
                if (ch[i] == 1) {
                    tmp += (i + " ");
                }
            }
            if (tmp.length() > 0) {
                System.out.println(tmp);
            }
        } else {
            ch[l] = 1;
            dfs(l + 1);
            ch[l] = 0;
            dfs(l + 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ch = new int[n + 1];
        dfs(1);
    }
}
