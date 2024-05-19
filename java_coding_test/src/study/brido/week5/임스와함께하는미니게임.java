package study.brido.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 임스와함께하는미니게임 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();

        int userCount = 0;
        if (game.equals("Y")) {
            userCount = 2;
        } else if (game.equals("F")) {
            userCount = 3;
        } else if (game.equals("O")) {
            userCount = 4;
        }

        Set<String> users = new HashSet<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            users.add(st.nextToken());
        }

        System.out.println(users.size() / (userCount - 1));
    }
}

