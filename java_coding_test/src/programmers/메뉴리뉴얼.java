package programmers;


import java.util.*;

public class 메뉴리뉴얼 {

    private static Set<String> combis = new HashSet<>();
    private static HashMap<String, Integer> courseInfo = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        //코스요리는 순서가 상관 없음 -> 조합 사용 Combination
        //주어진 단품 메뉴들에 대한 모든 조합 구하기
        // order 정렬
        // order.containAll해서 course 길이만큼 나온 조합을 anser에 추가
        Set<String> menuSet = new HashSet<>();
        for (String str : orders){
            char[] chars = str.toCharArray();
            for(Character c : chars){
                menuSet.add(String.valueOf(c));
            }
        }

        String[] menus = menuSet.toArray(new String[0]);

        for (int count : course){
            String[] combi = new String[count];
            combination(0, 0, menus, combi, orders);
        }


        Set<String> keySet = courseInfo.keySet();
        List<String> answerList = new ArrayList<>();



        for (int i = 0 ; i < course.length; i++) {
            int target = course[i];
            int max = 0;
            for (String key : keySet) {
                if (target == key.length()) {
                    if (max <= courseInfo.get(key)){
                        max = courseInfo.get(key);
                    }
                }
            }

            for (Map.Entry<String, Integer> entry : courseInfo.entrySet()){
                if(entry.getValue().equals(max) && entry.getKey().length() == target){
                    answerList.add(entry.getKey());
                }
            }
        }
        Collections.sort(answerList);

        String[] answer = new String[answerList.size()];
        for (int i = 0 ; i < answer.length ; i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    private static void combination(int level, int start, String[] menus, String[] combi, String[] orders){
        if (level == combi.length) {
            StringBuilder strBuilder = new StringBuilder();
            int count = 0;

            for (String order : orders) {
                boolean isContains = true;
                for (String c : combi){
                    if (!order.contains(c)) {
                        isContains = false;
                        break;
                    }
                }
                if (isContains) {
                    count++;
                }
            }

            if (count >= 2) {
                for (String c : combi) {
                    strBuilder.append(c);
                }
                courseInfo.put(strBuilder.toString(), count);
            }

            return;
        }
        for (int i = start; i < menus.length; i++){
            combi[level] = menus[i];
            combination(level + 1, i + 1, menus, combi, orders);
        }
    }


}
