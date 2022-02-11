package string;

import java.util.Scanner;

/*
* First : 2021/9/26
* Regular Expression!
* */
public class SelectNum {
    public static int solution(String string) {
        int answer = 0;
        String replaceAll = string.replaceAll("[^0-9]", "");
        answer = Integer.parseInt(replaceAll);
        return answer;
    }

    //ASCII NUMBER 사용
    public static int solution2(String s) {
        int answer = 0;
        for (char x : s.toCharArray()) {
            if (x >= 48 && x <= 57) {
                answer = answer * 10 + (x - 48);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        System.out.println("solution(string) = " + solution(string));
    }
}
