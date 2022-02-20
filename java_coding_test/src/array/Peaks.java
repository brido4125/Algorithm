package array;

import java.util.Scanner;

public class Peaks {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    private static int solution(int num,int[][] ary) {
        int answer = 0;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                boolean flag = true;
                for (int k = 0; k < dx.length; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx>=0 && nx < num && ny >= 0 && ny < num && ary[nx][ny] >= ary[i][j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    answer++;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] ary = new int[num + 2][num + 2];
        for (int i = 1; i < ary.length-1; i++) {
            for (int j = 1; j < ary.length - 1; j++) {
                ary[i][j] = sc.nextInt();
            }
        }

    }
}
