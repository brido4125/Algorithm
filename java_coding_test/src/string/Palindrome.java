package string;

import java.util.Scanner;
/*
 * First : 2021/9/26
 * String Only Alphabet!
 * 특수문자 제거 => RE 사용!
 * */
public class Palindrome {
    public static String solution(String str) {
        str = trimAndLower(str);
        System.out.println(str);
        StringBuilder answer = new StringBuilder(str);
        StringBuilder reverse = answer.reverse();
        String reverseString = reverse.toString();
        System.out.println(reverseString);
        if (str.equals(reverseString)) {
            return "YES";
        }else{
            return "NO";
        }
    }

    private static String trimAndLower(String string) {
        string = string.toLowerCase();
        string = string.replaceAll("[^a-z]", "");
        return string;
    }

   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.nextLine();
        System.out.println("solution(next) = " + solution(next));
    }
}
