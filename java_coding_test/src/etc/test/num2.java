package etc.test;


import java.util.ArrayList;

public class num2 {
    public static String solution(String[] log){
        String answer = "";

        ArrayList<Integer> hourList = new ArrayList<>();
        ArrayList<Integer> minuteList = new ArrayList<>();

        //일단 시간 계산을 위해 split으로 각각 리스트로 스트링 나누기
        for (String time : log) {
            String[] split = time.split(":", 2);
            hourList.add(Integer.parseInt(split[0]));
            minuteList.add(Integer.parseInt(split[1]));
        }

        ArrayList<Float> studyTimeList = new ArrayList<>();

        for (int i = 0; i < hourList.size(); i = i +2) {
            // (i + 1) - i => 연속된 시작시간, 중지시간 계산을 위해서
            int x  = (hourList.get(i + 1) - hourList.get(i)) * 60;
            float y = (minuteList.get(i + 1) - minuteList.get(i));
            // 시간 뺏을 때 2시간 이상
            float studyTime = x + y;
            //인정되는 공부시간 예외처리
            if (studyTime >= 5.0f) {
                if (studyTime > 105.0f) {
                    studyTime = 105.0f;
                }
                studyTimeList.add(studyTime);
            }
        }

        double[] ints = studyTimeList.stream().mapToDouble(d -> d).toArray();
        double sum = 0 ;
        for (double anInt : ints) {
            sum += anInt;
        }
        int hour = (int) (sum / 60);
        int minute = (int) (sum % 60);

        System.out.println("hour = " + hour);
        System.out.println("minute = " + minute);

        //hour가 한자리 수이면 앞에 0 더해주기
        if (hour < 10) {
            answer = "0"+Integer.toString(hour) + ":" + Integer.toString(minute);
        }else {
            answer = Integer.toString(hour) + ":" + Integer.toString(minute);
        }


        return answer;
    }


    public static void main(String[] args){
        String[] log = {"08:30", "09:00", "14:00", "16:00", "16:01", "16:06", "16:07", "16:11"};
        System.out.println("solution(log) = " + solution(log));
    }
}
