package etc.hashAndSet;

import java.util.*;

public class Anagram {
    private static String solution(String str1, String str2) {
        String answer = "YES";
        if (str1.length() != str2.length()) {
            return answer = "NO";
        }
        Map<Character, Integer> strMap1 = new HashMap<>();
        Map<Character, Integer> strMap2 = new HashMap<>();

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            strMap1.put(chars1[i], strMap1.getOrDefault(chars1[i], 0) + 1);
            strMap2.put(chars2[i], strMap2.getOrDefault(chars2[i], 0) + 1);
        }
        if (strMap1.size() != strMap2.size()) {
            return answer = "NO";
        }
        for (char ch : chars1) {
            if (strMap1.get(ch).intValue() != strMap2.get(ch).intValue()) {
                return answer = "NO";
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(solution(str1, str2));
    }
}
