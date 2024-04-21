package etc.test;

import java.util.Scanner;

public class Gugudan {

    /*
    * total = end - start + 1 = 전체 junk 개수
    * total % limit = 0 이면 limit의 수만큼 중간 junk로 나눠떨어짐
    * total % limit != 0 이면 해당 나머지 값이 마지막에 나와야할 최소단위의 갯수
    * limit % 4 => 중간 junk 내에서 남는 최소단위의 갯수(4개 찍고 남는 거)
    * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        int limit = sc.nextInt();
        while (start > end) {
            start = sc.nextInt();
            end = sc.nextInt();
            limit = sc.nextInt();
        }
        int total = end - start + 1;
        int smallMod = limit % 4;//4개 남고
        //start ~ start+1
        //
        for (int i = start; i < end + 1; i++) {
            printDan(i);
        }

    }

    private static void printDan(int num) {
        for (int i = 1; i < 10; i++) {
            System.out.printf("%d * %d = %d %5s",num,i,(num*i)," ");
            System.out.printf("%d * %d = %d %5s",num+1,i,(num+1)*i," ");
            System.out.printf("%d * %d = %d %5s",num+2,i,(num+2)*i," ");
            System.out.printf("%d * %d = %d %5s",num+3,i,(num+3)*i," ");
            System.out.println();
        }
    }
}
