package sds.excalibur;

import java.util.*;

public class Excalibur {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Point posA;
    static Point posB;
    static Point posC;
    static Point startingPosition = new Point();
    static int count = 0;
    static List<List<Character>> permutationList = new ArrayList<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int i = 1; i <= testCase; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            char[][] board = new char[N][M];
            int R = sc.nextInt();
            int K = sc.nextInt();
            int posY = R - 1;
            int posX = K - 1;
            for (int j = 0; j < board.length; j++) {
                String line = sc.next();
                for (int k = 0; k < board[j].length; k++) {
                    board[j][k] = line.charAt(k);
                    if (line.charAt(k) == 'A') {
                        posA = new Point(k, j);
                    } else if (line.charAt(k) == 'B') {
                        posB = new Point(k, j);
                    } else if (line.charAt(k) == 'C') {
                        posC = new Point(k, j);
                    }
                }
            }
            System.out.println("#"+i+" "+solution(board, posX, posY,N,M));
        }
    }

    private static void getPermutationByDfs(int L, char[] permutation, int[] check, char[] buried) {
        if (L == permutation.length) {
            ArrayList<Character> chars = new ArrayList<>();
            for (char c : permutation) {
                chars.add(c);
            }
            permutationList.add(chars);
        } else {
            for (int i = 0; i < check.length; i++) {
                if (check[i] == 0) {
                    permutation[L] = buried[i];
                    check[i] = 1;
                    getPermutationByDfs(L + 1, permutation, check, buried);
                    check[i] = 0;
                }

            }
        }
    }

    //Grec의 실좌표상 위치 : posX, posY
    private static int solution(char[][] board, int posX, int posY, int N, int M) {
        char[][] boardCopy = new char[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            System.arraycopy(board[i], 0, boardCopy[i], 0, board[0].length);
        }
        char[] buried = new char[3];
        buried[0] = 'A';
        buried[1] = 'B';
        buried[2] = 'C';
        char[] permutation = new char[3];
        int[] check = new int[3];
        getPermutationByDfs(0, permutation, check, buried);//6가지 순열 완성
        List<Integer> answerList = new ArrayList<>();
        int answer = 0;
        setFirstStartingPos(posX, posY);
        for (List<Character> characters : permutationList) {
            for (int j = 0; j < buried.length; j++) {
                answer += bfs(boardCopy, startingPosition.getX(), startingPosition.y, N, M, characters.get(j));
            }
            answer += bfs(boardCopy, startingPosition.getX(), startingPosition.y, N, M, 'S');
            answerList.add(answer);
            for (int i = 0; i < board.length; i++) {//board 다시 세팅
                System.arraycopy(board[i], 0, boardCopy[i], 0, board[0].length);
            }
            setFirstStartingPos(posX, posY);
            count = 0;
            answer = 0;
        }

        return answerList.stream().mapToInt(i -> i).min().getAsInt();
    }

    private static void setFirstStartingPos(int posX, int posY) {
        startingPosition.setX(posX);
        startingPosition.setY(posY);
    }


    private static int bfs(char[][] board, int posX, int posY,int N,int M,char target) {
        int[][] distance = new int[N][M];
        distance[posY][posX] = 1;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(posX, posY, board[posY][posX]));
        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            if (poll.getPurpose() == target) {
                count += 1;
                startingPosition.setX(poll.getX());
                startingPosition.setY(poll.getY());
                board[poll.getY()][poll.getX()] = '.';
                return distance[poll.getY()][poll.getX()] -1;
            }
            for (int i = 0; i < dx.length; i++) {//좌 하 우 상
                int nextX = poll.getX() + dx[i];
                int nextY = poll.getY() + dy[i];
                if (count == 3) {
                    if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N && distance[nextY][nextX] == 0 && board[nextY][nextX] == 'X') {//2차원 배열 내이고 가보지 않은 점이어야함
                        distance[nextY][nextX] = distance[poll.getY()][poll.getX()] + 1;
                        queue.offer(new Point(nextX, nextY, board[nextY][nextX]));
                    }
                }
                if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N && distance[nextY][nextX] == 0 && board[nextY][nextX] != 'X') {//2차원 배열 내이고 가보지 않은 점이어야함
                    distance[nextY][nextX] = distance[poll.getY()][poll.getX()] + 1;
                    queue.offer(new Point(nextX, nextY, board[nextY][nextX]));
                }
            }
        }
        return -1;
    }

    static class Point{
        int x;
        int y;
        char purpose;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public char getPurpose() {
            return purpose;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public Point() {
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, char k) {
            this.x = x;
            this.y = y;
            this.purpose = k;
        }
    }
}
