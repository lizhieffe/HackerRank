package ETL;

import java.util.Scanner;

public class GridWalking {

    private static int MOD = 1000000007;
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i = 0; i < testCases; ++i) {
            int dimensions = sc.nextInt();
            int steps = sc.nextInt();
            int start = sc.nextInt();
            int size = sc.nextInt();
            int[] pos = new int[dimensions];
            for (int j = 0; j < pos.length; j++)
                pos[j] = start;
            System.out.println(getNum(dimensions, size, steps, pos));
        }
    }
    
    private static int getNum(int dimension, int size, int steps, int[] pos) {
        if (steps == 0)
            return 1;
        int result = 0;
        for (int i = 0; i < pos.length; i++) {
            if (pos[i] > 1) {
                int[] tmpPos = new int[pos.length];
                System.arraycopy(pos, 0, tmpPos, 0, pos.length);
                --tmpPos[i];
                result = (result % MOD + getNum(dimension, size, steps - 1, tmpPos) % MOD) % MOD;
            }
            if (pos[i] < size - 1) {
                int[] tmpPos = new int[pos.length];
                System.arraycopy(pos, 0, tmpPos, 0, pos.length);
                ++tmpPos[i];
                result += getNum(dimension, size, steps - 1, tmpPos);
            }
        }
        return result;
    }
}