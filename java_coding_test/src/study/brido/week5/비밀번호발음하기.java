package study.brido.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 비밀번호발음하기 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String regex = "^(?=[^aeiou]*[aeiou])"        // 반드시 모음 포함
            + "(?!.*[^aeiou]{3})"                 // 자음 3개 연속 금지
            + "(?!.*[aeiou]{3})"                  // 모음 3개 연속 금지
            + "(?!.*([^aeiou])\\1)"               // 같은 글자 연속 금지 (자음)
            + "(?!.*(?![eo])([aeiou])\\2)"        // 같은 글자 연속 금지 (모음, ee와 oo는 허용)
            + "[a-z]*$";

    StringBuilder sb = new StringBuilder();
    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String pw = st.nextToken();
      if (pw.equals("end")) {
        break;
      }
      Pattern compile = Pattern.compile(regex);
      Matcher matcher = compile.matcher(pw);
      sb.append("<");
      sb.append(pw);
      sb.append("> ");
      if (matcher.matches()) {
        sb.append("is acceptable.\n");
      } else {
        sb.append("is not acceptable.\n");
      }
    }
    System.out.println(sb);
  }
}
