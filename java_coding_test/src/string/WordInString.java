package string;

import java.util.Scanner;

public class WordInString {
    public static String solution(String str) {
        String answer = "";
        int min = Integer.MIN_VALUE;
        /* 1 . string.split 을 사용한 풀이
        String[] wordList = str.split(" ");
        for (String x : wordList) {
            int len = x.length();
            if (len > min) {
                min = len;
                answer = x;
            }
        }*/
        /*
        * 2. indexOf 를 사용한 풀이
        * */
        int pos;
        while ((pos = str.indexOf(" ")) != -1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if (len > min) {
                min = len;
                answer = tmp;
            }
            str = str.substring(pos + 1);
        }
        if (str.length() > min) {
            answer = str;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        System.out.println(solution(string));

    }
}
