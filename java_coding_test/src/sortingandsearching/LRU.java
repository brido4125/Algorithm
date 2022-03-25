package sortingandsearching;

import java.util.*;
import java.util.stream.IntStream;


public class LRU {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cacheSize = sc.nextInt();
        int jobSize = sc.nextInt();
        int[] jobs = new int[jobSize];
        for (int i = 0; i < jobs.length; i++) {
            jobs[i] = sc.nextInt();
        }
        for (int i = 0; i < solution(cacheSize, jobs).length; i++) {
            System.out.print(solution(cacheSize, jobs)[i] + " ");
        }
    }

    private static int[] solution2(int cacheSize, int[] jobs) {
        int[] cache = new int[cacheSize];
        for (int x : jobs) {
            int pos = -1;
            for (int i = 0; i < cacheSize; i++) {
                if (x == cache[i]) {
                    pos= i;
                }
            }
            if (pos == -1) {
                for (int i = cacheSize - 1; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            } else {
                for (int i =  pos; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            }
            cache[0] = x;
        }
        return cache;
    }

    private static int[] solution(int cacheSize, int[] jobs) {
        int[] answer = new int[cacheSize];
        answer[0] = jobs[0];
        for (int i = 1; i < jobs.length; i++) {
            int elementToFind = jobs[i];
            if (Arrays.stream(answer).anyMatch(arg -> arg == elementToFind)) {
                //answer에서 lambda 변수의 index
                int dupIndex = IntStream.range(0, answer.length)
                        .filter(arg -> elementToFind == answer[arg])
                        .findFirst().orElse(-1);
                arrayShift(answer,dupIndex);
                answer[0] = jobs[i];
            } else {
                arrayShift(answer, answer.length - 1);
                answer[0] = jobs[i];
            }
        }
        return answer;
    }
    private static void arrayShift(int[] ary,int index) {
        for (int i = index; i >=1 ; i--) {
            ary[i] = ary[i - 1];
        }
    }
}
