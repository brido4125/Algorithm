package etc.dfsandbfs;

import java.util.Scanner;

public class MaxScore {
    static int num;
    static int limitTime;
    static int answer = 0;
    static int[] aryScore;
    static int[] aryTime;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        limitTime = sc.nextInt();
        aryScore = new int[num];
        aryTime = new int[num];
        for (int i = 0; i < num; i++) {
            aryScore[i] = sc.nextInt();
            aryTime[i] = sc.nextInt();
        }
        System.out.println(solution());
    }

    private static int solution() {
        dfs(0, 0, 0);
        return answer;
    }

    private static void dfs(int L, int sumOfScore, int sumOfTime) {
        if (sumOfTime > limitTime) {
            return;
        }
        if (L == num) {
            if (answer < sumOfScore) {
                answer = sumOfScore;
            }
        } else {
            dfs(L + 1, sumOfScore + aryScore[L], sumOfTime + aryTime[L]);
            dfs(L + 1, sumOfScore, sumOfTime);
        }
    }
}
