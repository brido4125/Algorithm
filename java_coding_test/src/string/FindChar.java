package string;

import java.util.Locale;
import java.util.Scanner;

public class FindChar {
    public static int solution(String str, char t){
        int count = 0;
        /*
        * 매견 변수로 들어온 값 모두 소문자로 변경!
        * */
        str = str.toLowerCase();
        t = Character.toLowerCase(t);
        /* < 전통적인 for 문 사용으로 풀기>
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == t) {
                count++;
            }
        }*/
        /*
        * forEach => array or List 만 사용가능 => String 은 변경해야함!
        * */
        for (char c : str.toCharArray()) {
            if (c == t) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);
        System.out.println(solution(str,c));
    }
}
