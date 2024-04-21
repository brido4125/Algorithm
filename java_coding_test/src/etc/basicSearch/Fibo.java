package etc.basicSearch;

import java.util.Arrays;
import java.util.Scanner;

public class Fibo {
    static int[] fibo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        fibo = new int[num + 1];//index 1에 1, index 2에 1, index 3에 2, index 4에 3
        solution(num);
        System.out.println(Arrays.toString(fibo));
    }


    private static int solution(int num) {
        if (fibo[num] > 0) {
            return fibo[num];
        }
        if (num == 1) {
            return fibo[1] = 1;
        } else if (num == 2) {
            return fibo[2] = 1;
        } else {
            return fibo[num] = solution(num - 1) + solution(num - 2);
        }
    }
}
