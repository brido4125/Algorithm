package stackandqueue;

import java.util.Scanner;
import java.util.Stack;

public class CraneGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int NUM = sc.nextInt();
        int[][] board = new int[NUM][NUM];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int movesLength = sc.nextInt();
        int[] moves = new int[movesLength];
        for (int i = 0; i < movesLength; i++) {
            moves[i] = sc.nextInt();
        }
        System.out.println( solution(board, moves));
    }

    private static int solution(int[][] board, int[] moves) {
        convertToIndex(moves);
        Stack<Integer> baguni = new Stack<>();
        return handleBaguni(board, moves, baguni);
    }

    private static int handleBaguni(int[][] board, int[] moves, Stack<Integer> baguni) {
        int count = 0;
        int recent = 0;
        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][move] != 0) {
                    //넣을값 vs 이전값이 같은 경우
                    if (board[j][move] == recent) {
                        baguni.pop();
                        recent = baguni.peek();
                        count += 2;
                        board[j][move] = 0;
                        break;
                    }
                    baguni.push(board[j][move]);
                    recent = board[j][move];
                    board[j][move] = 0;
                    break;
                }
            }
        }
        return count;
    }

    private static void convertToIndex(int[] moves) {
        for (int i = 0; i < moves.length; i++) {
            moves[i] -= 1;
        }
    }
}
