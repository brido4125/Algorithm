package stackandqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EduCourseDesign {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String requiredCourse = sc.next();
        String designedCourse = sc.next();
        System.out.println(solution(requiredCourse, designedCourse));
    }

    private static String solution2(String need, String plan) {
        String answer = "YES";
        Queue<Character> queue = new LinkedList<>();
        for (char ch : need.toCharArray()) {
            queue.add(ch);
        }
        for (char ch : plan.toCharArray()) {
            if (queue.contains(ch)) {
                if (ch != queue.poll()) {
                    return "NO";
                }
            }
        }
        if (!queue.isEmpty()) {
            return "NO";
        }
        return answer;
    }

    private static String solution(String requiredCourse, String designedCourse) {
        Queue<Character> requiredQueue = new LinkedList<>();
        Queue<Character> designedQueue = new LinkedList<>();
        for (Character ch : requiredCourse.toCharArray()) {
            requiredQueue.add(ch);
        }
        for (int i = 0; i < designedCourse.length(); i++) {
            if (isRequired(designedCourse, requiredQueue, i) && designedQueue.isEmpty()) {
                designedQueue.add(designedCourse.toCharArray()[i]);
                if (!designedQueue.peek().equals(requiredQueue.peek())) {
                    return "NO";
                }
            } else if (isRequired(designedCourse, requiredQueue, i)) {
                Character preSubject = requiredQueue.peek();
                if (designedQueue.contains(preSubject)) {
                    designedQueue.add(designedCourse.toCharArray()[i]);
                }else{
                    return "NO";
                }
                requiredQueue.poll();
            }
        }

        if (designedQueue.containsAll(requiredQueue)) {
            return "YES";
        }
        return "NO";
    }

    private static boolean isRequired(String designedCourse, Queue<Character> requiredQueue, int i) {
        boolean flag;
        Character firstElement = requiredQueue.peek();
        if (requiredQueue.contains(designedCourse.toCharArray()[i])) {
            return flag = true;
        }
        return false;
    }
}
