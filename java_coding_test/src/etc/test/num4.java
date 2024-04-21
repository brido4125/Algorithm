package etc.test;

import java.util.ArrayList;
import java.util.Arrays;

public class num4 {
    public static int[] solution(String s) {
        int[] answer = {};
        ArrayList<Integer> chuckList = new ArrayList<>();
        char[] chars = s.toCharArray();
        char compare = chars[0]; // 주어진 스트링의 요소들의 갯수를 구하기 위한 비교 변수
        int tmp = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == compare) {
                tmp++;
            }else {
                compare = chars[i];
                chuckList.add(tmp);
                tmp = 1;
            }
        }
        chuckList.add(tmp);

        //앞과 끝이 이어진경우
        if(chars[0] == chars[chars.length - 1]){
            int i = chuckList.get(0) + chuckList.get(chuckList.size() - 1);
            chuckList.remove(0);
            chuckList.remove(chuckList.size() - 1);
            chuckList.add(i);
        }

        int[] ints = chuckList.stream().mapToInt(i -> i).toArray();

        Arrays.sort(ints);
        answer = ints;
        System.out.println("Arrays.toString(answer) = " + Arrays.toString(answer));
        return answer;
    }

    public static void main(String[] args) {
        String s = "aaabbaaa";
        solution(s);
    }
}
