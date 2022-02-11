package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BigNum {
    public static List<Integer> solution(int n ,int[] ary) {
        List<Integer> answer = new ArrayList<>();
        answer.add(ary[0]);
        for (int i = 1 ; i < n; i++) {
            if(ary[i] > ary[i - 1]) answer.add(ary[i]);
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = sc.nextInt();
        }
        solution(n, ints);

    }
}
