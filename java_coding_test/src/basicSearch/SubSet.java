package basicSearch;

public class SubSet {
    static int n;
    static int[] check;

    public static void DFS(int L) {
        if (L == n + 1) {
            for (int i = 1; i <= 3; i++) {
                if (check[i] == 1) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
            return;
        }
        check[L] = 1;
        DFS(L + 1);
        check[L] = 0;
        DFS(L + 1);
    }

    public static void main(String[] args) {
        n = 3;
        check = new int[n + 1];
        DFS(1);
    }
}
