package stackandqueue;

import java.util.Scanner;
import java.util.Stack;

public class RightBracket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }

    private static String solution(String str) {
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char ch : chars) {
            if (stack.isEmpty()) {
                stack.add(ch);
            }
            if (stack.peek().equals('(')) {
                if (ch == '(') {
                    stack.add(ch);
                }
                stack.pop();
            } else if (stack.peek().equals(')')) {
                if (ch == ')') {
                    stack.add(ch);
                }
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return "YES";
        }
        return "NO";
    }

    private static String solution2(String str) {
        Stack<Character> openStack = new Stack<>();
        Stack<Character> closeStack = new Stack<>();
        char[] chars = str.toCharArray();
        if (chars[0] == ')' || chars[str.length() - 1] == '(') {
            return "NO";
        }
        for (Character ch : chars) {
            if (ch.equals('(')) {
                openStack.add(ch);
            } else if (ch.equals(')')) {
                closeStack.add(ch);
            }
        }
        if (openStack.size() == closeStack.size()) {
            return "YES";
        }
        return "NO";
    }
}
