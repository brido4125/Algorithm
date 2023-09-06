package basicSearch;

public class DFS {
    static Node root;

    public static void DFS(Node root) {
        if (root == null) {
            return;
        } else {
            DFS(root.lt);
            System.out.println(root.data);// 중위 순회
            DFS(root.rt);
        }
    }

    public static void main(String[] args) {
        /*
        * lefe node value => null
        * */
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        DFS(root);
    }
}
