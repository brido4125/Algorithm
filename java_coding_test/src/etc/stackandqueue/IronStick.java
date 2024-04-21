package etc.stackandqueue;

import java.util.Scanner;
import java.util.Stack;

public class IronStick {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        solution(str);
    }

    private static int solution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
            } else {//닫는 괄호 처리
                stack.pop();
                if (str.charAt(i - 1) == '(') {//Laser Point
                    answer += stack.size();
                } else {
                    answer++;
                }
            }
        }
        return answer;
    }
}
