package sortingandsearching;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class CheckDup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] ary = new int[num];
        for (int i = 0; i < ary.length; i++) {
            ary[i] = sc.nextInt();
        }
        System.out.println(solution2(num, ary));

    }

    private static char solution2(int num, int[] ary) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int element : ary) {
            hashMap.put(element, hashMap.getOrDefault(element, 0) + 1);
        }
        Collection<Integer> values = hashMap.values();
        for (Integer value : values) {
            if (!value.equals(1)) {
                return 'D';
            }
        }
        return 'U';
    }

    private static char solution(int num, int[] ary) {
        for (int i = 0; i < ary.length; i++) {
            for (int j = i+1; j < ary.length; j++) {
                if (ary[i] == ary[j]) {
                    return 'D';
                }
            }
        }
        return 'U';
    }
}
