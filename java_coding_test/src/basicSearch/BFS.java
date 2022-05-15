package basicSearch;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    static Node root;

    private static void BFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int L = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            System.out.print(L + " : ");
            for (int i = 0; i < len; i++) {
                Node poll = queue.poll();
                System.out.print(poll.data+" ");
                if (poll.lt != null) {
                    queue.offer(poll.lt);
                }
                if (poll.rt != null) {
                    queue.offer(poll.rt);
                }
            }
            L++;
            System.out.println();
        }
    }
    public static void main(String[] args) {
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        BFS(root);
    }
}
