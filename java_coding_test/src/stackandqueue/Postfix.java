package stackandqueue;

import java.util.Scanner;
import java.util.Stack;

public class Postfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }

    private static int solution(String str) {
        Stack<Integer> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (isOperator(ch)) {
                int value1 = stack.pop();
                int value2 = stack.pop();
                int res = calculator(ch, value1, value2);
                stack.push(res);
            } else {
                stack.push(Character.getNumericValue(ch));
            }
        }

        return stack.pop();
    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '/' || ch == '*';
    }

    private static int calculator(char ch, int value1, int value2) {
        if (ch == '+') {
            return value1 + value2;
        } else if (ch == '-') {
            return value2 - value1;
        } else if (ch == '/') {
            return value2 / value1;
        } else if (ch == '*') {
            return value1 * value2;
        }
        return 0;
    }
}
