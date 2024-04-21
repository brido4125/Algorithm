package etc.dfsandbfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tomato {
    static int [][] board;
    static int [][] check;
    static int total = 0;
    static Queue<Point> queue;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int M;
    static int N;
    static int sizeOfEmpty = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();//6
        N = sc.nextInt();//4
        board = new int[N][M];//앞이 행 뒤가 열
        //check = new int[N][M];//앞이 행 뒤가 열
        queue = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int elem = sc.nextInt();
                if (elem == 1) {
                    queue.offer(new Point(j, i));
                    //check[i][j] = 0;
                } else if (elem == -1) {
                    sizeOfEmpty+=1;
                    //check[i][j] = -1;
                }
                total += elem;
                board[i][j] = elem;
            }
        }
        if (isAlreadyDone(total)) {
            System.out.println(0);
        }else if(isEmpty(total)){
            System.out.println(-1);
        }
        System.out.println(bfs());
        System.out.println("check = " + Arrays.deepToString(check));
    }

    public static int bfs() {
        int days = -1;

        int queueSize = queue.size();
        int count = 0;
        while(!queue.isEmpty()) {
            Point poll = queue.poll();
            //left -> down -> right -> up
            for (int i = 0; i < dx.length; i++) {
                int nextX = poll.getX() + dx[i];
                int nextY = poll.getY() + dy[i];
                if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N && board[nextY][nextX] == 0) {
                    //check[nextY][nextX] = check[poll.getY()][poll.getX()] + 1;
                    board[nextY][nextX] = 1;
                    queue.offer(new Point(nextX, nextY));
                }
            }
            count++;
            if (count == queueSize) {
                days++;
                count = 0;
                queueSize = queue.size();
            }
        }
        if (isThereZero(board)) {
            return -1;
        }
        return days;
    }

    private static boolean isThereZero(int[][] board) {
        for (int[] ints : board) {
            for (int anInt : ints) {
                if (anInt == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
    * tomato가 전부 익은 경우
    * */
    private static boolean isAlreadyDone(int sum) {
        int size = board.length * board[0].length;
        return size == sum;
    }

    /*
     * 상자에 토마토가 없는 경우 handling
     * */
    private static boolean isEmpty(int sum) {
        int size = board.length * board[0].length;
        return sum == -size;
    }

    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
