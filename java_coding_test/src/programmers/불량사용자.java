package programmers;

import java.util.LinkedList;
import java.util.List;

public class 불량사용자 {
    static String[] userId;
    static String[] permu;
    static String[] bannedId;
    static int[] checked;
    static int answer = 0;
    static List<List<String>> permuList = new LinkedList<>();
    public int solution(String[] user_id, String[] banned_id) {
        userId = user_id;
        bannedId = banned_id;

        permu = new String[banned_id.length];
        checked = new int[user_id.length];

        permutation(0, banned_id.length);
        return answer;
    }


    private static void permutation(int n, int length){
        if (n == length) {
            boolean isSame = true;
            for (int i = 0 ; i < permu.length; i++){
                if (permu[i].length() != bannedId[i].length()){
                    isSame = false;
                    break;
                }
                char[] p = permu[i].toCharArray();
                char[] b = bannedId[i].toCharArray();
                for (int j = 0 ; j < p.length; j++){
                    if (b[j] != '*' && b[j] != p[j]){
                        isSame = false;
                        break;
                    }
                }
            }

            if (isSame) {
                List<String> target = new LinkedList<>();
                for (String s : permu){
                    target.add(s);
                }
                if (!permuList.isEmpty()){
                    for (List<String> strs : permuList){
                        if(target.containsAll(strs)){
                            return;
                        }
                    }
                }
                permuList.add(target);
                answer++;
            }
            return;
        }
        for (int i = 0 ; i < userId.length; i++){
            //check visited
            if (checked[i] == 0){
                permu[n] = userId[i];
                checked[i] = 1;
                permutation(n + 1, length);
                checked[i] = 0;
            }
        }
    }
}
