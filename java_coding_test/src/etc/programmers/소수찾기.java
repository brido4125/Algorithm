package etc.programmers;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {
    static int answer = 0;
    static char[] nums;
    static char[] permu;
    static int[] check;
    static Set<Integer> intValue = new HashSet<>();

    public static int solution(String numbers) {

        nums = numbers.toCharArray();

        // i가 뽑을 개수
        for (int i = 1 ; i <= numbers.length(); i++){
            permu = new char[i];
            check = new int[numbers.length()];
            makeNumber(0, i);
        }

        for (Integer target : intValue){
            if(isPrimeNumber(target)){
                answer+=1;
            }
        }
        return answer;
    }

    private static void makeNumber(int level, int leng){
        if (level == leng){
            String s = String.valueOf(permu);
            int value = Integer.parseInt(s);
            intValue.add(value);
            return;
        }
        for (int i = 0 ; i < nums.length ; i++){
            // not visited
            if (check[i] == 0){
                permu[level] = nums[i];
                check[i] = 1;
                makeNumber(level + 1, leng);
                check[i] = 0;
            }

        }

    }

    private static boolean isPrimeNumber(int target){
        if (target < 2){
            return false;
        }
        for (int i = 2; i < (int)Math.sqrt(target) + 1; i++){
            if (target % i == 0){
                return false;
            }
        }
        return true;
    }
}
