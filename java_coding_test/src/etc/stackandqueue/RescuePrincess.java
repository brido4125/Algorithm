package etc.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RescuePrincess {
    private static Integer solution(int number, int flag) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= number; i++) {
            queue.add(i);
        }
        while (queue.size() != 1) {
            for (int i = 0; i < flag; i++) {
                if (flag - 1 == i) {
                    queue.poll();
                    break;
                }
                Integer poll = queue.poll();
                queue.add(poll);
            }
        }
        return queue.peek();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int first = sc.nextInt();
        System.out.println(solution(number, first));
    }
}
