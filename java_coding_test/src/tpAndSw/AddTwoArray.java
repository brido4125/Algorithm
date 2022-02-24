package tpAndSw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddTwoArray {
    private static List<Integer> solution(int num1, int[] ary1, int num2, int[] ary2) {
        List<Integer> answer = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        /**
         * index1 and index2 should be smaller than each array length
         * if any value is larger or equal than array length,break while loop
         */
        while (index1 < num1 && index2 < num2) {
            if (ary1[index1] > ary2[index2]) {
                answer.add(ary2[index2]);
                index2++;
            } else if (ary1[index1] <= ary2[index2]) {
                answer.add(ary1[index1]);
                index1++;
            }
        }
        if (index1 == num1) {
            for (int i = index2; i < ary2.length; i++) {
                answer.add(ary2[i]);
            }
        } else if (index2 == num2) {
            for (int i = index1; i < ary1.length; i++) {
                answer.add(ary1[i]);
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int[] ary1 = new int[num1];
        for (int i = 0; i < ary1.length; i++) {
            ary1[i] = sc.nextInt();
        }
        int num2 = sc.nextInt();
        int[] ary2 = new int[num2];
        for (int i = 0; i < ary2.length; i++) {
            ary2[i] = sc.nextInt();
        }
        for (Integer num:solution(num1,ary1,num2,ary2)) {
            System.out.println(num + " ");
        }
    }
}
