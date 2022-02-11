package string;

import java.util.Scanner;
/*
* First : 2021/9/24
* */
public class ReverseChar {
    public static String solution(String str) {
        String answer = "";
        char[] chars = str.toCharArray();
        int lt = 0, rt = chars.length - 1;
        while (lt < rt) {
            // if both indexes are Alphabet?
            if(Character.isAlphabetic(chars[lt]) && Character.isAlphabetic(chars[rt])){
                char tmp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = tmp;
            }
            lt++;
            rt--;
        }
        answer = String.valueOf(chars);
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println("solution(str) = " + solution(str));
    }
}
