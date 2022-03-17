package school.week1;

public class Main {
    private static int process(int command, int param1, int param2) {
        int[][] school = new int[3][3];
        int[][] student = new int[10000][3];

        int counter;

        switch (command) {
            case 1:
                return (school[param1][0]);
            case 2:
                return (school[param1][1]);
            case 3:
                return (student[param1][0]);
            case 4:
                return (student[param1][1]);
            case 5:
                student[param1][2] = param2;
                return 0;
        }

        if (command == 0) {
            for (counter = 0; counter < 3; counter++) {
                school[counter][0] = (int)(Math.random() * 1000);
                school[counter][1] = (int)(Math.random() * 1000);
            }
            for (counter = 0; counter < 10000; counter++) {
                student[counter][0] = (int)(Math.random() * 1000);
                student[counter][1] = (int)(Math.random() * 1000);
                student[counter][2] = -1;
            }

            return 0;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
