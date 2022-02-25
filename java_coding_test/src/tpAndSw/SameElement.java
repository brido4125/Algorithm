package tpAndSw;

import java.util.*;

public class SameElement {
    private static List<Integer> solution1(int num1, int[] ary1, int num2, int[] ary2) {
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(ary1);
        Arrays.sort(ary2);
        int index1 = 0;
        int index2 = 0;
        while (index1 < num1 && index2 < num2) {
            if (ary1[index1] < ary2[index2]) {
                index1++;
            } else if (ary1[index1] > ary2[index2]) {
                index2++;
            } else if (ary1[index1] == ary2[index2]) {
                answer.add(ary1[index1]);
                index1++;
                index2++;
            }
        }
        return answer;
    }

    private static List<Integer> solution2(int num1, int[] ary1, int num2, int[] ary2) {
        List<Integer> answer = new ArrayList<>();
        for (int k : ary1) {
            for (int i : ary2) {
                if (k == i) {
                    answer.add(k);
                    break;
                }
            }
        }
        Collections.sort(answer);
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
        for (int i = 0; i < num2; i++) {
            ary2[i] = sc.nextInt();
        }
        for (Integer num: solution1(num1,ary1,num2,ary2)) {
            System.out.print(num + " ");
        }
    }
}
