package study.brido.solvedac;

import java.util.Scanner;
import java.util.Stack;

public class 팰린드롬수 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String next = scanner.next();
            if (next.equals("0")) {
                break;
            }
            char[] charArray = next.toCharArray();
            Stack<Character> stk = new Stack<>();
            for (int i = 0; i < charArray.length; i++) {
                stk.add(charArray[i]);
            }
            boolean res = true;
            for (char c : charArray) {
                Character pop = stk.pop();
                if (c != pop) {
                    res = false;
                }
            }
            if (res) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
