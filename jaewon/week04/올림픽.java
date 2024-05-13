import java.io.*;
import java.util.*;

// 금메달 수가 더 많은 나라 
// 금메달 수가 같으면, 은메달 수가 더 많은 나라
// 금, 은메달 수가 모두 같으면, 동메달 수가 더 많은 나라 

public class Main {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void sol() throws Exception {
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]);
        int K = Integer.parseInt(tokens[1]);
        List<Country> countries = new ArrayList<>();

        Country kC = null;
        for (int i = 0; i < N; ++i) {
            tokens = br.readLine().split(" ");
            var country = new Country();
            country.id = Integer.parseInt(tokens[0]);
            country.gold = Integer.parseInt(tokens[1]);
            country.silver = Integer.parseInt(tokens[2]);
            country.bronze = Integer.parseInt(tokens[3]);
            countries.add(country);
            if (country.id == K) {
                kC = country;
            }
        }

        int rank = 0;
        for (var c : countries) {
            if (c.id == kC.id)
                continue;
            if (kC.compareTo(c) < 0) {
                rank++;
            }
        }
        System.out.println(rank + 1);

        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().sol();
    }

    private static class Country implements Comparable<Country> {
        public int id;
        public int gold;
        public int silver;
        public int bronze;

        public int compareTo(Country o) {
            if (gold != o.gold) {
                return gold - o.gold;
            } else if (silver != o.silver) {
                return silver - o.silver;
            }
            return bronze - o.bronze;
        }

        public String toString() {
            return String.valueOf(id);
        }
    }
}
