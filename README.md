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