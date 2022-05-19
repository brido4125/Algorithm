package dfsandbfs;

import java.util.Scanner;

public class Dog {
    static int sum = 0;
    static int limit;
    static int[] ary;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        limit = sc.nextInt();
        int num = sc.nextInt();
        ary = new int[num+1];
        ary[0] = 0;
        for (int i = 1; i < ary.length; i++) {
            ary[i] = sc.nextInt();
        }
        System.out.println(solution(ary));

    }

    /*
    * 가장 무겁게 태운 무게 리턴
    * */
    private static int solution(int[] ary) {
        dfs(sum, 0);
        return answer;
    }

    private static void dfs(int sum, int index) {
        if (sum > limit) {
            return;
        }
        if (index == ary.length-1) {
            if (answer < sum) {
                answer = sum;
            }
        } else {
            dfs(sum + ary[index + 1], index + 1);
            dfs(sum, index + 1);
        }
    }
}
