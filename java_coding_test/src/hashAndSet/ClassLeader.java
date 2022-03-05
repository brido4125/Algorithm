package hashAndSet;

import java.util.*;

public class ClassLeader {


    private static char solution2(int num, char[] ary) {
        char answer = ' ';
        Map<Character, Integer> count = new HashMap<>();
        for (char c : ary) {
            count.put(c, count.getOrDefault(c, 0)+1);
        }
        int max = Integer.MIN_VALUE;
        for (char key : count.keySet()) {
            if (count.get(key) > max) {
                max = count.get(key);
                answer = key;
            }
        }
        return answer;
    }
    private static char solution1(int num, char[] ary) {
        char answer = ' ';
        Map<Character, Integer> count = new HashMap<>();
        String registeredCandidate = "ABCDE";
        for (char ch : registeredCandidate.toCharArray()) {
            count.put(ch,0);
        }
        for (char ch : ary) {
            if (count.containsKey(ch)) {
                int old = count.get(ch);
                count.replace(ch, old+1);
            }
        }
        Collection<Integer> values = count.values();
        Integer max = Collections.max(values);
        for (char ch : registeredCandidate.toCharArray()) {
            if (Objects.equals(count.get(ch), max)) {
                answer = ch;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String res = sc.next();
        System.out.println(solution2(num, res.toCharArray()));
    }
}
