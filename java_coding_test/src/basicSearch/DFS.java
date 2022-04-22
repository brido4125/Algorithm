package basicSearch;

public class DFS {
    static Node root;

    public static void DFS(Node root) {
        if (root == null) {
            return;
        } else {
            //System.out.print(root.data+ " "); // 전위 순회 : 루트을 먼저 방문
            DFS(root.lt);
            System.out.print(root.data+ " "); // 중위 순회 : 루트를 중간에 방문
            DFS(root.rt);
            //System.out.print(root.data+ " "); // 후위 순회 : 루트를 마지막에 방문
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
