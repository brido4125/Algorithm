package test;

import java.util.Arrays;

public class num1 {
    public static int[] solution(int[] arr) {
        int[] answer = {0,0,0};
        for (int j : arr) {
            if (j == 1) {
                answer[0]++;
            } else if (j == 2) {
                answer[1]++;
            } else if (j == 3) {
                answer[2]++;
            }
        }
        int max = getMax(answer);
        System.out.println("max = " + max);
        System.out.println(Arrays.toString(answer));
        for (int i = 0; i < answer.length; i++) {
            answer[i] = max - answer[i];
        }
        return answer;
    }
    public static int getMax(int[] arr){
        int max = arr[0];
        for (int j : arr) {
            if (max < j) {
                max = j;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 3, 3, 3};
        System.out.println("Arrays.toString(solution(arr)) = " + Arrays.toString(solution(arr)));
    }
}
