package greedy;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PickUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] heights = new int[N];
        int[] weights = new int[N];
        for (int i = 0; i < N; i++) {
            heights[i] = sc.nextInt();
            weights[i] = sc.nextInt();
        }
        System.out.println(solution(heights, weights));

    }

    private static int solution(int[] heights, int[] weights) {
        int count = 0;
        List<Athlete> athletes = new LinkedList<>();

        for (int i = 0; i < heights.length; i++) {
            athletes.add(new Athlete(heights[i], weights[i]));
        }

        for (int i = 0; i < athletes.size(); i++) {
            Athlete find = athletes.get(0);
            athletes.remove(find);
            if (Athlete.compare(find, athletes)) {
                count++;
            }
            athletes.add(find);
        }
        return count;
    }

    static class Athlete {
        private int height;
        private int weight;

        public Athlete(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        public int getHeight() {
            return height;
        }

        public int getWeight() {
            return weight;
        }

        public static boolean compare(Athlete x, List<Athlete> y) {
            for (Athlete athlete : y) {
                if (x.getWeight() < athlete.getWeight() && x.getHeight() < athlete.getHeight()) {
                    return false;
                }
            }
            return true;
        }
    }
}
