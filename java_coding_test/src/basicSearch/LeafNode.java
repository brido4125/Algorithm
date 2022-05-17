package basicSearch;

import java.util.LinkedList;
import java.util.Queue;

public class LeafNode {
    static Node root;

    public static int DFS(int L, Node node) {
        if (node.lt == null && node.rt == null) {
            return L;
        } else {
            return Math.min(DFS(L + 1, node.lt), DFS(L + 1, node.rt));
        }
    }

    public static int BFS(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        int L = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node cur = queue.poll();
                if (cur.lt == null && cur.rt == null) {
                    return L;
                } else {
                    queue.offer(cur.rt);
                    queue.offer(cur.lt);
                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.rt.lt = new Node(23);
        root.rt.rt = new Node(21);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        System.out.println(BFS(root));
    }
}
