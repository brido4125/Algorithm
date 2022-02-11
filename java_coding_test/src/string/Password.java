package string;

import java.util.Scanner;

/*
* String 형태의 이진수를 10진수로 바꾸는 방법
* */
public class Password {
    public static String solution(int num, String str) {
        StringBuilder answer = new StringBuilder();
        str = str.replace("*", "0").replace("#", "1");
        int length = str.length() / num;
        String[] segment = new String[num];
        int[] asciiNum = new int[num];
        for (int i = 0; i < num; i++) {
            int startIndex = i + i*(length-1);
            segment[i] = str.substring(startIndex, startIndex + length);
            asciiNum[i] = Integer.parseInt(segment[i], 2);
            answer.append((char) asciiNum[i]);
        }
        return answer.toString();
    }
    public static String solution2(int n, String str) {
        String answer = "";
        for (int i = 0; i < n; i++) {
            String tmp = str.substring(0,7).replace("*", "0").replace("#", "1");
            int num = Integer.parseInt(tmp, 2);
            answer += (char)num;
            str = str.substring(7);
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nextInt = sc.nextInt();
        String next = sc.next();
        System.out.println("solution(next) = " + solution(nextInt,next));
    }
}
