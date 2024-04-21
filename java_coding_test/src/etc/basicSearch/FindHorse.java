package etc.basicSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindHorse {
    private static int solution(int pos1, int des) {
        Queue<Integer> q = new LinkedList();
        q.offer(pos1);
        int count = 0;
        int[] check = new int[10001];
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer poll = q.poll();
                check[poll] = 1;
                if (poll != des) {
                    if (check[straight1(poll)] == 0) {
                        q.offer(straight1(poll));
                        check[straight1(poll)] = 1;
                    }
                    if (check[back1(poll)] == 0 && back1(poll) > 1) {
                        q.offer(back1(poll));
                        check[back1(poll)] = 1;
                    }
                    if (check[straight5(poll)] == 0) {
                        q.offer(straight5(poll));
                        check[straight5(poll)] = 1;
                    }
                } else {
                    return count;
                }
            }
            count++;
        }
        return 0;
    }

    private static int straight1(int pos) {
        return pos + 1;
    }

    private static int back1(int pos) {
        return pos - 1;
    }

    private static int straight5(int pos) {
        return pos + 5;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pos1 = sc.nextInt();
        int pos2 = sc.nextInt();
        System.out.println(solution(pos1, pos2));
    }
}
