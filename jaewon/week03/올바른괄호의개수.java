class Solution {
    int N;
    private int dfs(int openCnt, int closeCnt) {
        if (N == openCnt) {
            return 1;
        } else if (openCnt < closeCnt) {
            return 0;
        }
        return dfs(openCnt + 1, closeCnt) + dfs(openCnt, closeCnt + 1);
    }
    public int solution(int n) {
        N = n;
        return dfs(0, 0);
    }
}
