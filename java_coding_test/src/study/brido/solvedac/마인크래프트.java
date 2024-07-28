package study.brido.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 마인크래프트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<int[]> answerList = new ArrayList<>();

        for (int i = 0 ; i <= 256; i++) {
            int time = ground(i, board, B);
            if (time < 0) {
                continue;
            }
            answerList.add(new int[]{time, i});
        }

        answerList.sort((o1, o2) -> {
            if (o1[0] > o2[0]) {
                return 1;
            } else if (o1[0] < o2[0]) {
                return -1;
            }
            if (o1[1] < o2[1]) {
                return 1;
            }
            return -1;
        });

        System.out.println(answerList.get(0)[0] + " " + answerList.get(0)[1]);
    }

    private static int ground(int height, int[][] board, int block) {
        int addBlock = 0;
        int useBlock = 0;
        int timeCount = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] > height) {
                    // 낮추기 -> 블럭 저장
                    int save = board[i][j] - height;
                    addBlock += save;
                    timeCount += (2 * save);
                } else if (board[i][j] < height) {
                    // 높이기 -> 블럭 사용
                    int use = height - board[i][j];
                    useBlock += use;
                    timeCount += use;
                }
            }
        }

        // negative value means cannot do ground task.
        if ((addBlock + block) - useBlock >= 0) {
            return timeCount;
        }
        return -1;
    }
}
