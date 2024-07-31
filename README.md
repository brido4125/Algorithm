## Combination(조합)
- nCk 값을 구하는 경우 사용
```java
 public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] combi = new int[K];
        boolean[] checked = new boolean[N + 1];

        //nCk 구현
        dfs(0, 1, combi, checked);
        System.out.println(count);
    }

    private static void dfs(int level, int startIndex, int[] combi, boolean[] checked) {
        if (level == K) {
            count += 1;
            return;
        }
        for (int i = startIndex; i <= N; i++) {
            if (!checked[i]) {
                checked[i] = true;
                combi[level] = i;
                dfs(level + 1, i + 1, combi, checked);
                checked[i] = false;
            }
        }
    }
```


## BFS 시 주의사항
특정 좌표를 큐에 넣을 때, 해당 좌표의 상태 변화 (ex. 갈 수 있는곳 -> 벽)는
먼저 기존의 상태를 확인한 다음 변화시키도록 구현해야한다.

또한 큐에 좌표를 넣는 코드 앞에는 기존 상태 확인(문제 조건 만족 등) 하고
큐에 좌표를 넣는 코드 다음에는 해당 좌표를 다녀갔다라는 표시 (벽으로 만들기) 한다.

### 제일 기본적인 코드 형태
```java
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        board[start[0]][start[1]] = 'X';
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < dRow.length; i++) {
                int nextRow = dRow[i] + poll[0];
                int nextCol = dCol[i] + poll[1];

                if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M && board[nextRow][nextCol] != 'X') {
                    if (board[nextRow][nextCol] == 'P') {
                        answer += 1;
                    }
                    queue.add(new int[]{nextRow, nextCol});
                    board[nextRow][nextCol] = 'X';
                }
            }
        }


```