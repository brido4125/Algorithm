package study.brido.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 균형잡힌세상 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = "";
        while (true) {
            s = br.readLine();
            if (s.equals(".")) {
                break;
            }
            String replace = s.replaceAll("[^\\[\\]\\(\\)]", "");
            Stack<Character> stk = new Stack<>();
            for (Character c : replace.toCharArray()) {
                if (c.equals('(') || c.equals('[')) {
                    stk.add(c);
                } else if (c.equals(']') || c.equals(')')) {
                    if (!stk.isEmpty()) {
                        if (stk.peek().equals('[') && c.equals(']')) {
                            stk.pop();
                        } else if (stk.peek().equals('(') && c.equals(')')) {
                            stk.pop();
                        } else { // 반례 : ( [ ) ] ( ) )
                            stk.add(c);
                        }
                    } else {
                        stk.add(c);
                    }
                }
            }
            if (stk.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
