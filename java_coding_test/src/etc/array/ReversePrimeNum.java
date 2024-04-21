package etc.array;

import java.util.*;

public class ReversePrimeNum {
    private static List<Integer> solution(int num, int[] ary) {
        List<Integer> answer = new ArrayList<>();
        for (int each : ary) {
            int reverserNum = reverseNumber(each);
            boolean flag = isPrimeNumber(reverserNum);
            if (flag) {
                answer.add(reverserNum);
            }
        }
        return answer;
    }

    private static boolean isPrimeNumber(int num) {
        //Exception 1
        if (num == 1) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int reverseNumber(int num) {
        String string = Integer.toString(num);
        char[] charArray = string.toCharArray();
        List<Character> characterList = new ArrayList<>();
        for (char each : charArray) {
            characterList.add(each);
        }
        Collections.reverse(characterList);
        for (int i = 0; i < characterList.size(); i++) {
            charArray[i] = characterList.get(i);
        }
        return Integer.parseInt(new String(charArray));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] ary = new int[num];
        for (int i = 0; i < ary.length; i++) {
            ary[i] = sc.nextInt();
        }
        List<Integer> solution = solution(num, ary);
        System.out.println("solution = " + solution);
    }
}
