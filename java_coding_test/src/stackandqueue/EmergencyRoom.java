package stackandqueue;

import java.util.*;

public class EmergencyRoom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sequence = sc.nextInt();

        int[] ary = new int[num];
        for (int i = 0; i < ary.length; i++) {
            ary[i] = sc.nextInt();
        }
        System.out.println(solution(num, sequence, ary));
    }
    static class Patient{
        private int priority;
        private int index;

        public Patient(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }
    }

    private static int solution(int num, int sequence, int[] ary) {
        int answer = 0;
        int max;
        Patient[] patients = setPatients(ary);
        Queue<Patient> queue = new LinkedList<>(Arrays.asList(patients));
        while (true) {
            max = Arrays.stream(ary).max().getAsInt();
            Patient peek = queue.peek();
            if (peek.priority < max) {
                Patient poll = queue.poll();
                queue.add(poll);
            } else if(peek.priority == max){
                queue.poll();
                answer++;
                ary[peek.index] = Integer.MIN_VALUE;
                if (peek.index == sequence) {
                    break;
                }
            }
        }
        return answer;
    }

    private static Patient[] setPatients(int[] ary) {
        Patient[] patients = new Patient[ary.length];
        for (int i = 0; i < patients.length; i++) {
            patients[i] = new Patient(ary[i], i);
        }
        return patients;
    }

}
