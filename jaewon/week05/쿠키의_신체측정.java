import java.io.*;
import java.util.*;

public class Main {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void sol() throws Exception {
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        char[][] map = new char[size][size];
        int[] col = new int[size];

        for (int i = 0; i < size; i++) {
            String input = br.readLine();
            for (int j = 0; j < size; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == '*') {
                    col[i]++;
                }
            }
        }

        int heartCol = 0, heartRow = 0;
        int maxCol = 0;
        for (int i = 0; i < size; i++) {
            if (col[i] > maxCol) {
                maxCol = col[i];
                heartCol = i;
            }
        }

        for (int i = 0; i < size; i++) {
            if (map[heartCol - 1][i] == '*')
                heartRow = i;
        }

        bw.append((heartCol + 1) + " " + (heartRow + 1) + "\n");

        int rightHand = 0, leftHand = 0, rightLeg = 0, leftLeg = 0, body = 0;

        for (int i = heartRow - 1; i >= 0; i--) {
            if (map[heartCol][i] == '*')
                leftHand++;
        }
        for (int i = heartRow + 1; i < size; i++) {
            if (map[heartCol][i] == '*')
                rightHand++;
        }
        for (int i = heartCol + 1; i < size; i++) {
            if (map[i][heartRow] != '*') {
                heartCol = i;
                break;
            } else
                body++;
        }
        for (int i = heartCol; i < size; i++) {
            if (map[i][heartRow - 1] == '*')
                leftLeg++;
        }
        for (int i = heartCol; i < size; i++) {
            if (map[i][heartRow + 1] == '*')
                rightLeg++;
        }

        bw.append(leftHand + " " + rightHand + " " + body + " " + leftLeg + " " + rightLeg);
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
