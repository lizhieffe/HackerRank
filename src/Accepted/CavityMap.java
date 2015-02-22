package Accepted;

import java.util.Scanner;

public class CavityMap {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[][] depth = new int[n][n];
        for (int i = 0; i < n; ++i) {
        	String s = sc.nextLine();
        	char[] c = s.toCharArray();
        	for (int j = 0; j < n; ++j)
        		depth[i][j] = (int)(c[j] - '0');
        }
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j) {
                if (i == 0 || i == n - 1 || j == 0 || j == n - 1)
                    continue;
                if (depth[i][j] > depth[i - 1][j] && depth[i][j] > depth[i + 1][j]
                        && depth[i][j] > depth[i][j - 1] && depth[i][j] > depth[i][j + 1])
                    depth[i][j] = 10;
            }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int val = depth[i][j];
                if (val == 10)
                    System.out.print("X");
                else
                    System.out.print(depth[i][j]);
            }
            System.out.println();
            
        }
    }
}
