package study.brido;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 단어정렬 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        List<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String target = scanner.next();
            if (!list.contains(target)) {
                list.add(target);
            }
        }

        list.sort((o1, o2) -> o1.length() > o2.length() ? 1 : o1.length() == o2.length() ? o1.compareTo(o2) : -1);

        for (String s : list) {
            System.out.println(s);
        }
    }
}
