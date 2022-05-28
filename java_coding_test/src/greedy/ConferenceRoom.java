package greedy;

import java.util.*;

public class ConferenceRoom {
    static class Conference implements Comparable<Conference>{
        private int startTime;
        private int endTime;

        public Conference(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        @Override
        public int compareTo(Conference conference) {
            //this -> parameter로 순서 가져가면 오름차순
            if (this.getEndTime() == conference.getEndTime()) {
                return this.startTime - conference.startTime;
            } else {
                return this.getEndTime() - conference.getEndTime();
            }
        }

        @Override
        public String toString() {
            return "startTime = " + startTime + " endTime = " + endTime;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Conference> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(new Conference(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(list);

        System.out.println(solution(list));

    }

    private static int solution(List<Conference> list) {
        int answer = 0;
        int endTime = 0;
        for (Conference conference : list) {//현재 객체와 다음번 객체 비교하는 로직
            if (conference.getStartTime() >= endTime) {
                answer++;
                endTime = conference.getEndTime();
            }
        }
        return answer;
    }
}
