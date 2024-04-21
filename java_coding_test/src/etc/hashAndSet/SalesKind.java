package etc.hashAndSet;

import java.util.*;

public class SalesKind {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalLength = sc.nextInt();
        int rangeNum = sc.nextInt();
        int[] ary = new int[totalLength];
        for (int i = 0; i < ary.length; i++) {
            ary[i] = sc.nextInt();
        }
        for (Integer x : solution(totalLength, rangeNum, ary)) {
            System.out.print(x + " ");
        }
    }

    private static List<Integer> solution(int totalLength, int rangeNum, int[] ary) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        int rightPointer = rangeNum-1;
        int leftPointer;
        for (leftPointer = 0; leftPointer <= rightPointer; leftPointer++) {
            map.put(ary[leftPointer], map.getOrDefault(ary[leftPointer], 0) + 1);
        }
        answer.add(map.size());
        leftPointer = 0;

        while (rightPointer < totalLength-1) {
            map.put(ary[leftPointer], map.get(ary[leftPointer]) - 1);
            if (map.get(ary[leftPointer]) == 0) {
                map.remove(ary[leftPointer]);
            }
            leftPointer++;
            rightPointer++;
            map.put(ary[rightPointer], map.getOrDefault(ary[rightPointer], 0) + 1);
            answer.add(map.size());
        }
        return answer;
    }
}
