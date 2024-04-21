package etc.hashAndSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Naughtiness {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int studentNum = sc.nextInt();
        int[] ary = new int[studentNum];
        for (int i = 0; i < ary.length; i++) {
            ary[i] = sc.nextInt();
        }
        solution(ary);
    }

    private static ArrayList<Integer> solution(int[] ary) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] tmp = ary.clone();
        Arrays.sort(tmp);
        for (int i = 0; i < ary.length; i++) {
            if (ary[i] != tmp[i]) {
                answer.add(i+1);
            }
        }
        return answer;
    }
}
