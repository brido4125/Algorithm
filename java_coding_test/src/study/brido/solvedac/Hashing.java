package study.brido.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Hashing {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = 31;
        int M = 1234567891;

        int length = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String target = st.nextToken();
        char[] charArray = target.toCharArray();// -96
        BigInteger sum = BigInteger.ZERO;
        BigInteger hash = BigInteger.ONE;
        for (char c : charArray) {
            BigInteger v = BigInteger.valueOf((c - 96)).multiply(hash);
            sum = sum.add(v).mod(BigInteger.valueOf(M));
            hash = hash.multiply(BigInteger.valueOf(31));
        }
        System.out.println(sum.longValue());
    }
}
