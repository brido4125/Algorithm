package string;

import java.util.Scanner;

public class CompressString {
    public static String solution(String str) {
        StringBuilder answer = new StringBuilder();
        str += " ";
        char[] chars = str.toCharArray();
        int cnt = 1;
        for (int i = 0; i < chars.length-1; i++) {
            if (str.charAt(i) == str.charAt(i+1)) {
                cnt++;
            }else{
                answer.append(chars[i]);
                if(cnt != 1){
                    answer.append(cnt);
                }
                cnt = 1;
            }
        }
        return answer.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        System.out.println("solution(next) = " + solution(next));

    }
}
