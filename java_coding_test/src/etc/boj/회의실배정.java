package etc.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 회의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        List<Conference> list = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.add(new Conference(start, end));
        }

        list.sort((c1, c2) -> c1.getEnd() == c2.getEnd() ?
            Integer.compare(c1.getStart(), c2.start) : Integer.compare(c1.getEnd(), c2.getEnd()));
        int answer = 0;
        int endTime = 0;

        for (Conference c : list) {
            if (endTime <= c.getStart()) {
                endTime = c.getEnd();
                answer += 1;
            }
        }

        System.out.println(answer);
    }

    public static class Conference {
        private int start;
        private int end;

        public Conference(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }
    }

}
