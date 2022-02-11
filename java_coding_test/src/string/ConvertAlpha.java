package string;
import java.util.Arrays;
import java.util.Scanner;
/*
* 10min use =>
* */
public class ConvertAlpha {
    public static StringBuilder solution(String str) {
        StringBuilder answer = new StringBuilder();
        /* Wrong Answer
        for (int i = 0; i < chars.length; i++) {
            if (Character.isUpperCase(chars[i])) {
                chars[i] = Character.toLowerCase(chars[i]);
            } else if(Character.isLowerCase(chars[i])) {
                chars[i] = Character.toUpperCase(chars[i]);
            }
        }
        answer = Arrays.toString(chars);*/
        /*
        * 65 ~ 90 : Upper Case ASCII Number
        * 97 ~ 122 : Lower Case ASCII Number
        * */
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                answer.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                answer.append(Character.toUpperCase(c));
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println("solution(str) = " + solution(str));
    }
}
