package school.week1;

public class Main {
    void run_contest() {
        int schoolNum = 3;
        int studentNum = 1000;
        Point2D[] schoolPoints = setSchoolPoints(schoolNum);
        Point2D[] studentPoints = setStudentPoints(studentNum);
        //학생 좌표를 하나 불러 올때, 바로 학교 배정하기

    }
    private Point2D[] setSchoolPoints(int schoolNum) {
        Point2D[] schools = new Point2D[schoolNum];
        for (int i = 0; i < schoolNum; i++) {
            schools[i] = get_random_position();
        }
        return schools;
    }

    private Point2D[] setStudentPoints(int studentNum) {
        Point2D[] students = new Point2D[studentNum];
        for (int i = 0; i < studentNum; i++) {
            students[i] = get_random_position();
        }
        return students;
    }

    /**
     * 좌표은 0~999까지
     * @return
     */
    private Point2D get_random_position() {
        return new Point2D((int)(Math.random()*1000),(int)(Math.random()*1000));
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run_contest();
    }
}
