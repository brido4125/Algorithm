package stackandqueue;

import java.util.*;

public class BracketChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }

    private static StringBuilder solution(String str) {
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        List<Character> answerList = new ArrayList<>();
        int counter = 0;
        StringBuilder answer = new StringBuilder();
        for (char ch : chars) {
            stack.push(ch);
            counter = counterHandler(stack, counter);
            addAnswerChar(stack, counter, answer);
        }
        return answer;
    }

    private static void addAnswerChar(Stack<Character> stack, int counter, StringBuilder anwser) {
        if (counter == 0 && !stack.peek().equals(')')) {
            anwser.append(stack.peek());
        }
    }

    private static int counterHandler(Stack<Character> stack, int counter) {
        if (stack.peek().equals('(')) {
            counter++;
        } else if (stack.peek().equals(')')) {
            counter--;
        }
        return counter;
    }

}
