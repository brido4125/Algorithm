package etc.boj;

public class 셀프넘버 {
    public static void main(String[] args) {

        boolean[] board = new boolean[100000];

        for (int i = 1; i <= 10000; i++) {
            int split = 0;
            for (Character c : String.valueOf(i).toCharArray()) {
                split += Integer.parseInt(String.valueOf(c));
            }
            int selfNum = i + split;
            board[selfNum] = true;
        }

        for (int i = 1; i <=10000; i++) {
            if (!board[i]) {
                System.out.println(i);
            }
        }
    }
}
