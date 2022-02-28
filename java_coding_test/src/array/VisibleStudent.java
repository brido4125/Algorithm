package array;

import java.util.Arrays;
import java.util.Scanner;

public class VisibleStudent {
    public static int solution(int n, int [] ints) {
        int answer = 1;
        int max = ints[0];
        for (int height:ints) {
            if (max < height) {
                max = height;
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ints = new int[n];
        //i는 0부터 n-1까지 증가한다.=> 배열의 모든 index에 접근할 수 있다.
        for (int i = 0; i < ints.length; i++) {
            ints[i] = sc.nextInt();
        }
        String x = "";
        System.out.println(Arrays.toString(ints));
        System.out.println("n = " + n);
        System.out.println("ints = " + Arrays.toString(ints));
        System.out.println("solution(n,ints) = " + solution(n,ints));
    }
}
/**
 * 길이가 6인 배열
 *  5
 *  길이가 10인 배열
 *  9
 *  길이가 100인 배열
 *  99
 *  길이가 Num인 배열
 *  num-1
 */