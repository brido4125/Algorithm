package sortingandsearching;

import java.util.Scanner;

public class SortXY {

    static class Point implements Comparable<Point>{
        @Override
        public int compareTo(Point point) {
            if (this.getX() == point.getX()) {
                return this.getY() - point.getY();
            } else {
                return this.getX() - point.getX();
            }
        }

        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Point[] points = new Point[num];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(sc.nextInt(), sc.nextInt());
        }
        solution(points);
    }

    private static void solution(Point[] points) {
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                if (points[i].getX() == points[j].getX()) {
                    if (points[i].getY() > points[j].getY()) {
                        Point temp;
                        temp = points[i];
                        points[i] = points[j];
                        points[j] = temp;
                    }
                } else if (points[i].getX() > points[j].getX()) {
                    Point temp;
                    temp = points[i];
                    points[i] = points[j];
                    points[j] = temp;
                }
            }
        }
        for (Point point : points) {
            System.out.println(point.getX() + " " +point.getY());
        }
    }
}
