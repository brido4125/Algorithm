package basicSearch;

public class Recursion {
    public static void recursion(int n) {
        if (n == 0) {
            return;
        } else {
            recursion(n - 1);
            System.out.print(n + " "); // 1 2 3 ... 출력
        }
    }

    public static void main(String[] args) {
        recursion(6);
    }
}
