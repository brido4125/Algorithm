package etc.hashAndSet;

import java.util.*;

public class NumberK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int k = sc.nextInt();
        int[] ary = new int[length];
        for (int i = 0; i < length; i++) {
            ary[i] = sc.nextInt();
        }
        System.out.println(solution(k, ary));
    }

    /**
     * 3장 뽑으니까 for문 3번...
     * @param k
     * @param ary
     * @return
     */
    private static int solution(int k, int[] ary) {
        TreeSet<Integer> integerSet = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < ary.length; i++) {
            for (int j = i + 1; j < ary.length; j++) {
                for (int l = j + 1; l < ary.length; l++) {
                    integerSet.add(ary[i] + ary[j] + ary[l]);
                }
            }
        }
        int cnt = 0;
        for (int x : integerSet) {
            cnt++;
            if (cnt == k) {
                return x;
            }
        }
        return -1;
    }
}
