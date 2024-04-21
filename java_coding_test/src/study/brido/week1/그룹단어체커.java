package study.brido.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 그룹단어체커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int answer = 0 ;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String word = st.nextToken();
            boolean res = isGroupWord(word);
            if (res) {
                answer += 1;
            }
        }
        System.out.println(answer);
    }

    private static boolean isGroupWord(String word) {
        Set<Character> charSet = new HashSet<>();
        boolean result = true;
        char[] charArray = word.toCharArray();
        char before = '0';
        for (Character c : charArray) {
            if (charSet.contains(c) && !c.equals(before)) {
                result = false;
                break;
            }
            before = c;
            charSet.add(c);
        }
        return result;
    }
}
