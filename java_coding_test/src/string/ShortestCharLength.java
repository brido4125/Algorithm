package string;

import java.util.Arrays;
import java.util.Scanner;

public class ShortestCharLength {
    public static int[] solution(String str, char c) {
        int[] answer = new int[str.length()];
        int p = 10000;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                p = 0 ;
            }
            else{
                p++;
            }
            answer[i] = p;
        }
        p = 1000;
        for (int i = str.length()-1; i >= 0; i--) {
            if (str.charAt(i) == c) {
                p = 0;
            }else{
                p++;
                answer[i] = Math.min(answer[i], p);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        char c = sc.next().charAt(0);
        System.out.println(Arrays.toString(solution(next, c)));

    }
}
