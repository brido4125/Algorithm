package study.brido;

import java.math.BigInteger;
import java.util.Scanner;

public class 팩토리얼0의개수 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        BigInteger fac = BigInteger.ONE;
        for (int i = 1; i <= N; i++) {
            fac = fac.multiply(BigInteger.valueOf(i));
        }
        int res = 0;
        char[] charArray = String.valueOf(fac).toCharArray();
        for (int i = charArray.length - 1; i >= 0; i--) {
            if (charArray[i] != '0') {
                break;
            }
            res += 1;
        }
        System.out.println(res);
    }
}
