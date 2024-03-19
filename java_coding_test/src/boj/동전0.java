package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// data 중복, 극단 값 (K == 1)
public class 동전0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Integer K = Integer.valueOf(st.nextToken());

        List<Integer> priceList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Integer price = Integer.valueOf(st.nextToken());
            if (price <= K) {
                priceList.add(price);
            }
        }
        int sum = 0;

        priceList.sort(Collections.reverseOrder());

        for (Integer p : priceList) {
            if (p > K) {
                continue;
            }
            sum += (K / p);
            K = (K % p);
        }

        System.out.println(sum);
    }
}
