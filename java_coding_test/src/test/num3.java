package test;


import java.util.*;

public class num3 {
    public static int solution(String[] ings, String[] menu, String[] sell) {
        int answer = 0;
        //ingredient key value로
        Map<String,String> ingsMap = new HashMap<>();
        for(int i = 0 ; i < ings.length ; i++){
            String[] s = ings[i].split(" ",2);
            ingsMap.put(s[0],s[1]);
        }
        System.out.println("ingsMap = " + ingsMap);
        //munu를 스플릿해서 각각 스트링으로
        List<String> menuKind = new ArrayList<>();
        List<String> needIngs = new ArrayList<>();
        List<String> price = new ArrayList<>();
        for(int i = 0 ; i < menu.length ; i++){
            String[] s = menu[i].split(" ",3);
            menuKind.add(s[0]);
            needIngs.add(s[1]);
            price.add(s[2]);
        }

        System.out.println("menuKind = " + menuKind);
        System.out.println("needIngs = " + needIngs);
        System.out.println("price = " + price);
        
        
        int [] ingsPrice = getIngsPrice(needIngs,ingsMap);//원가 구하기
        int[] margin = getMargin(ingsPrice, price); // 상품 순서대로 마진

        System.out.println("ingsPrice = " + Arrays.toString(ingsPrice));
        System.out.println("margin = " + Arrays.toString(margin));

        //sell split
        Map<String,String> sellMap = new HashMap<>();
        for(int i = 0 ; i < sell.length ; i++){
            String[] s = sell[i].split(" ",2);
            sellMap.put(s[0],s[1]);
        }
        System.out.println("sellMap = " + sellMap);
        //주문 수량만큼 곱해서 메뉴별 마진 구하기
        int[] total = new int[menuKind.size()];
        for (int i = 0; i < menuKind.size(); i++) {
            if (sellMap.containsKey(menuKind.get(i))) {
                total[i] = Integer.parseInt(sellMap.get(menuKind.get(i))) * margin[i];
            }
            System.out.println("===============");
            System.out.println("sellMap.get(menuKind.get(i)) = " + sellMap.get(menuKind.get(i)));
            System.out.println("===============");
        }
        for (int x : total) {
            answer += x;
        }
        return answer;
    }
    //원가 구하는 메서드
    // 1번째 인수 : 필요한 성분 스트링
    // 2번째 인수 : 성분 가격 들어있는 map
    public static int[] getIngsPrice(List<String> list, Map<String,String> ingsMap){
        int [] sum = new int[list.size()];
        for(int i = 0 ;i < list.size() ; i++){
            char[] chars = list.get(i).toCharArray();
            for (Character c : chars) {
                sum[i] += Integer.parseInt(ingsMap.get(c.toString()));
            }
        }
        return sum;
    }

    //(판매가격 - 원가) 해서 이익 배열 구하는 메서드
    public static int[] getMargin(int[] ings, List<String> sellprice) {
        int [] sum = new int[sellprice.size()];
        for (int i = 0; i < sum.length; i++) {
            sum[i] = Integer.parseInt(sellprice.get(i)) - ings[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        String []ings = {
                "r 10", "a 23", "t 124", "k 9"
        };
        String[] menu = {
                "PIZZA arraak 145", "HAMBURGER tkar 180", "BREAD kkk 30", "ICECREAM rar 50", "SHAVEDICE rar 45", "JUICE rra 55", "WATER a 20"
        };
        String[] sell = {
                "BREAD 5", "ICECREAM 100", "PIZZA 7", "JUICE 10", "WATER 1"
        };
        System.out.println(solution(ings,menu,sell));

    }
}
