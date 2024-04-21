package etc.dfsandbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Coin {
    static int N;
    static int price;
    static int[] check = new int[500];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[] ary = new int[N];
        for (int i = 0; i < ary.length; i++) {
            ary[i] = sc.nextInt();
        }
        price = sc.nextInt();
        System.out.println(solution(ary));

    }

    private static int solution(int[] ary) {
        return bfs(ary);
    }

    private static int bfs(int[] ary) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int L = 0;
        int maxValue = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int curNode = queue.poll();
                if (curNode == price && maxValue > L) {
                    maxValue = L;
                    return L;
                }
                for (int j = 0; j < N; j++) {
                    int nextNode = curNode + ary[j];
                    if (check[nextNode] == 0) {
                        check[nextNode] = 1;
                        queue.offer(nextNode);
                    }

                }
            }
            L++;
        }
        return 0;
    }
}
