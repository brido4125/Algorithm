package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * First : 2021/9/24
 * */
public class ReverseWord {
    public static ArrayList<String> solution(int n,String[] wordArray) {
        /*
        * StringBuilder().reverse() 를 이용한 풀이
        * */
        ArrayList<String> answer = new ArrayList<>();
        for (String x : wordArray) {
            String tmp = new StringBuilder(x).reverse().toString();
            answer.add(tmp);
        }
        /*
        * 내 풀이
        * */
        for (String x : wordArray) {
            char[] s = x.toCharArray();
            for (int i = 0; i < (s.length / 2) ; i++) {
                char tmp = s[i];
                s[i] = s[s.length - 1 - i];
                s[s.length - 1 - i] = tmp;
            }
            String tmp = Arrays.toString(s);
            answer.add(tmp);
        }
        /*
        * <reverse algorithm> 외워두기!
        * */
        for (String x : wordArray) {
            char[] s = x.toCharArray();
            int lt = 0, rt = x.length() - 1; // 각각 왼쪽 젤 끝, 오른쪽 젤 끝의 index
            while (lt < rt) {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
            String tmp = String.valueOf(s);
            answer.add(tmp);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nextInt = sc.nextInt();
        String[] wordArray = new String[nextInt];
        for (int i = 0; i < wordArray.length; i++) {
            wordArray[i] = sc.next();
        }
        for (String s : solution(nextInt,wordArray)) {
            System.out.println("s = " + s);
        }
    }
}
