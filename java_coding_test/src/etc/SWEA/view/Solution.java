package etc.SWEA.view;

import java.util.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    public static void main(String args[]) throws Exception
    {
		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int[] ary = new int[T];//T가 size역할
            for (int i = 0; i < ary.length; i++) {
                ary[i] = sc.nextInt();
            }
            System.out.println("#" + test_case + " "+solution(ary));
            T=sc.nextInt();
        }
    }

    private static int solution(int[] ary) {
        int sum = 0;
        int max = 0;
        for (int i = 2; i < ary.length - 2; i++) {
            int leftMax = Math.max(ary[i - 2], ary[i - 1]);
            int rightMax = Math.max(ary[i + 2], ary[i + 1]);
            int highest = Math.max(leftMax, rightMax);
            if (ary[i] - highest > 0) {
                int ableView = ary[i] - highest;
                sum += ableView;
            }
        }
        return sum;
    }
}