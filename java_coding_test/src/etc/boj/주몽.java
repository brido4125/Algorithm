package etc.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주몽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        int[] ary = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        int startIdx = 0;
        int endIdx = 1;
        int cnt = 0;

        while (endIdx < N) {
            // 두 재료의 합이 M과 같으면 갑옷을 만들 수 있음
            // 두 포인터가 같은 위치에 있다면 두 재료 중 하나를 더 선택하기 위해 end를 오른쪽으로 이동
            if (startIdx == endIdx) {
                endIdx++;
            } else if (ary[startIdx] + ary[endIdx] == M) {
                cnt++;
                endIdx++;
            } else if (ary[startIdx] + ary[endIdx] < M) {
                // 두 재료의 합이 M보다 작으면 두 번째 포인터를 오른쪽으로 이동
                endIdx++;
            } else {
                // 두 재료의 합이 M보다 크면 첫 번째 포인터를 오른쪽으로 이동
                startIdx++;
            }
        }

        System.out.println(cnt);
    }
}
