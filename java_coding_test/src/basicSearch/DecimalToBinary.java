package basicSearch;

import java.util.Scanner;

public class DecimalToBinary {
    public static void binary(int dec) {
        if (dec == 0) {
            return;
        }
        else{
            //System.out.print(dec % 2 +" ");
            binary(dec / 2);
            System.out.print(dec % 2 +" ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        binary(num);
    }
}
