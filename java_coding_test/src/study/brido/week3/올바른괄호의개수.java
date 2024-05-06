package study.brido.week3;

import java.util.Stack;

public class 올바른괄호의개수 {
    static int depth;
    static int answer;

    public int solution(int n) {
        depth = n * 2;
        dfs(0, new Stack<Character>());
        return answer;
    }

    private static void dfs(int level, Stack<Character> stk) {
        if (level == depth) {
            if (stk.peek().equals('(')) {
                return;
            } else if (isRight(stk)) {
                answer += 1;
            }
            return;
        }
        stk.push('(');
        dfs(level + 1, stk);
        stk.pop();

        stk.push(')');
        dfs(level + 1, stk);
        stk.pop();
    }

    private static boolean isRight(Stack<Character> stk) {
        Stack<Character> buf = new Stack<>();
        for (Character c : stk) {
            if (!buf.isEmpty() && buf.peek().equals('(') && c.equals(')')) {
                buf.pop();
            } else {
                buf.add(c);
            }
        }
        if (buf.isEmpty()) {
            return true;
        }
        return false;
    }
}

