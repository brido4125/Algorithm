package string;

import java.util.Scanner;
/*
 * First : 2021/9/25
 * */
public class RecursiveStr {
    public static boolean solution(String str) {
        boolean answer = false;
        str = str.toLowerCase();
        char[] chars = str.toCharArray();
        int lt = 0, rt = chars.length-1;
        while (lt < rt) {
            answer = chars[lt] == chars[rt];
            lt++;
            rt--;
        }
        /* StringBuilder 사용해서 해결
        String tmp = new StringBuilder(str).reverse().toString();
        return str.equals(tmp);
        */
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        System.out.println("solution(string) = " + solution(string));

    }
}
