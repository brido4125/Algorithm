package etc.tpAndSw;

import java.util.Scanner;

public class SerialNaturalSum {
    private static int solution(int num) {
        int answer = 0;
        int leftPointer = 0;
        int cutNum = num / 2 + 1;
        int sum = 0;
        int[] ary = new int[cutNum];
        for (int i = 0; i < cutNum; i++) {
            ary[i] = i + 1;//index 0에는 1 들어가고, index 1에는 2 들어감
        }
        for (int rightPointer = 0; rightPointer < ary.length; rightPointer++) {
            sum += ary[rightPointer];
            if (sum == num) {
                answer++;
            }
            while (sum >= num) {
                sum -= ary[leftPointer];
                leftPointer++;
                if (sum == num) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(solution(num));
    }
}
