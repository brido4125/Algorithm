package string;

import java.util.Scanner;
/*
 * First : 2021/9/25
 * */
public class RemoveDupChar {
    public static StringBuilder solution(String str) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(str.charAt(i)) == i) {
                answer.append(str.charAt(i));
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println("solution(str) = " + solution(str));
    }
}
