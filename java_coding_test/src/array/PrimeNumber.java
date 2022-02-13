package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeNumber {
    private static int solution(int num) {
        int[] checkAry = new int[num + 1];
        List<Integer> primeList = new ArrayList<Integer>();
        int answer = 0;
        for (int i = 2; i < checkAry.length; i++) {
            if (checkAry[i] == 0) {
                answer++;
                primeList.add(i);
            }
            for (int j = i; j < checkAry.length; j++) {
                if (j % i == 0) {
                    checkAry[j] = 1;
                }
            }
        }
        System.out.println("primeList = " + primeList);
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        System.out.println("solution(i) = " + solution(i));
    }
}
