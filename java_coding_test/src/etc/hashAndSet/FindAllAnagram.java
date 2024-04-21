package etc.hashAndSet;

import java.util.*;

public class FindAllAnagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String target = sc.next();
        int solution = solution(str, target);
        System.out.println(solution);
    }

    private static int solution(String str, String target) {
        Map<Character, Integer> targetMap = targetCharToMap(target);

        int targetLength = target.length();
        char[] strCharAry= str.toCharArray();

        Map<Character, Integer> strMap = initStrMap(targetLength, strCharAry);

        int anwser = 0;
        int lt = 0;
        int count = str.length() - targetLength;
        for (int i = 0; i < count; i++) {
            if (targetMap.equals(strMap)) {
                anwser++;
            }
            strMap.put(strCharAry[lt], strMap.get(strCharAry[lt]) - 1);
            if (strMap.get(strCharAry[lt]) == 0) {
                strMap.remove(strCharAry[lt]);
            }
            lt++;
            int rt = lt + targetLength - 1;
            strMap.put(strCharAry[rt], strMap.getOrDefault(strCharAry[rt], 0) + 1);
        }
        if (targetMap.equals(strMap)) {
            anwser++;
        }
        return anwser;
    }

    private static Map<Character, Integer> initStrMap(int targetLength, char[] strCharAry) {
        Map<Character, Integer> initMap = new HashMap<>();
        for (int i = 0; i < targetLength; i++) {
            initMap.put(strCharAry[i], initMap.getOrDefault(strCharAry[i], 0) + 1);
        }
        return initMap;
    }

    private static Map<Character,Integer> targetCharToMap(String target) {
        Map<Character, Integer> targetMap = new HashMap<>();
        for (Character ch: target.toCharArray()) {
            targetMap.put(ch, targetMap.getOrDefault(ch, 0) + 1);
        }
        return targetMap;
    }
}
