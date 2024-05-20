import java.io.*;
import java.util.*;

public class Main {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int[] dLine = { -1, 0, 0, 1 };
    int[] dCol = { 0, -1, 1, 0 };

    private void sol() throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int[] cur = null;

        for (int i = 0; i < N; i++) {
            String[] tokens = br.readLine().split(" ");
            for (int k = 0; k < N; k++) {
                map[i][k] = Integer.parseInt(tokens[k]);
                if (map[i][k] == 9) { // 상어
                    cur = new int[] { i, k };
                    map[i][k] = 0;
                }
            }
        }
        int size = 2;
        int eatCnt = 0; // 먹은 물고기 수
        int moveCnt = 0; // 움직인 총 거리

        while (true) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
                if (o1[2] != o2[2]) {
                    return Integer.compare(o1[2], o2[2]);
                } else if (o1[0] != o2[0]) {
                    return Integer.compare(o1[0], o2[0]);
                } else {
                    return Integer.compare(o1[1], o2[1]);
                }
            });
            boolean[][] visit = new boolean[N][N];

            pq.add(new int[] { cur[0], cur[1], 0 }); // l 좌표, c 좌표, 이동 거리
            visit[cur[0]][cur[1]] = true;
            boolean isAte = false;

            while (!pq.isEmpty()) {
                cur = pq.poll();

                if (map[cur[0]][cur[1]] != 0 && map[cur[0]][cur[1]] < size) { // 먹을 수 있다면
                    map[cur[0]][cur[1]] = 0; // 물고기 먹음
                    eatCnt++;
                    moveCnt += cur[2]; // 움직인 거리를 총 움직인 거리에 추가
                    isAte = true; // 먹이 먹었다고 체크
                    break;
                }

                for (int k = 0; k < 4; k++) {
                    int nl = cur[0] + dLine[k];
                    int nc = cur[1] + dCol[k];

                    if (nl < 0 || nc < 0 || nc >= N || nl >= N
                            || visit[nl][nc] || map[nl][nc] > size)
                        continue;

                    pq.add(new int[] { nl, nc, cur[2] + 1 });
                    visit[nl][nc] = true;
                }
            }

            if (!isAte) { // 먹은게 없다면 종료
                break;
            }
            if (size == eatCnt) { // 자신의 크기와 동일한 수의 물고기를 먹을 때마다 크기가 1 증가
                size++;
                eatCnt = 0;
            }
        }

        bw.append(moveCnt + "\n");
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
