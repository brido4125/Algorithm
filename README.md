## Combination(조합)
조합의 시간 복잡도는 O(2^n)
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


## Permuation(순열)
순열의 시간 복잡도는 O(n^2)
## 중복 순열
```java
    static void permutation(int L, int[] per, int[] ary) {
        if (L == 2) {

            return;
        }
        for (int i = 0; i < ary.length; i++) {
            per[L] = ary[i];
            permutation(L + 1, per, ary);
        }
    }
```
- nCr에 해당 하는 값들 -> n == ary.length, r == per.length
- 중복 순열이라 checked 배열과 for 문 i가 0부터 시작


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
<!---LeetCode Topics Start-->
# LeetCode Topics
## Array
|  |
| ------- |
| [0027-remove-element](https://github.com/brido4125/Algorithm/tree/master/0027-remove-element) |
| [0088-merge-sorted-array](https://github.com/brido4125/Algorithm/tree/master/0088-merge-sorted-array) |
## Two Pointers
|  |
| ------- |
| [0027-remove-element](https://github.com/brido4125/Algorithm/tree/master/0027-remove-element) |
| [0088-merge-sorted-array](https://github.com/brido4125/Algorithm/tree/master/0088-merge-sorted-array) |
## Sorting
|  |
| ------- |
| [0088-merge-sorted-array](https://github.com/brido4125/Algorithm/tree/master/0088-merge-sorted-array) |
<!---LeetCode Topics End-->