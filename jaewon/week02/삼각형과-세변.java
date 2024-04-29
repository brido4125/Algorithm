import java.io.*;
import java.util.*;

public class Main {
    int[] nums = new int[3];

    private void sol() throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            var st = new StringTokenizer(line, " ");

            nums[0] = Integer.parseInt(st.nextToken());
            nums[1] = Integer.parseInt(st.nextToken());
            nums[2] = Integer.parseInt(st.nextToken());
            if (nums[0] == 0)
                return;

            Arrays.sort(nums);
            System.out.println(check());
        }
    }

    private String check() {
        if (nums[0] == nums[2])
            return "Equilateral";
        else if (nums[0] + nums[1] <= nums[2])
            return "Invalid";
        else if (nums[0] == nums[1] || nums[1] == nums[2])
            return "Isosceles";
        else
            return "Scalene";
    }

    public static void main(String[] args) throws Exception {
        new Main().sol();
    }

}
