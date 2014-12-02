package PartiallyWrong;

import java.util.Scanner;

public class TheGridSearch {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int d = 0; d < n; d++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int[][] a = new int[r][c];
            sc.nextLine();
            for (int i = 0; i < r; i++) {
                String tmp = sc.nextLine();
                char[] tmpC = tmp.toCharArray();
                for (int j = 0; j < c; j++)
                    a[i][j] = (int)(tmpC[j] - '0');
            }
                
            int tr = sc.nextInt();
            int tc = sc.nextInt();
            int[][] t = new int[tr][tc];
            sc.nextLine();
            for (int i = 0; i < tr; i++) {
                String tmp = sc.nextLine();
                char[] tmpC = tmp.toCharArray();
                for (int j = 0; j < tc; j++)
                    t[i][j] = (int)(tmpC[j] - '0');
            }
            boolean result = false;
            for (int i = 0; i < r - tr + 1; i++) {
                if (found(a, i, t) == true ) {
                	result = true;
                    break;
                }
            }
            if (result == true)
            	System.out.println("YES");
            else
            	System.out.println("NO");
        }
    }
    
    private static boolean found(int[][] a, int r, int[][] t) {
        long val = 0;
        long tmp = 0;
        for (int i = 0; i < t.length; i++)
            for (int j = 0; j < t[0].length; j++) {
                val += (i + 1) * Math.pow(10, t[0].length - j - 1) * t[i][j];
                tmp += (i + 1) * Math.pow(10, t[0].length - j - 1) * a[r + i][j];
            }
        for (int k = 0; k <= a[0].length - t[0].length; k++) {
            if (k != 0) {
                for (int i = 0; i < t.length; i++) {
                    tmp -= a[r + i][k - 1] * (i + 1) * Math.pow(10, t[0].length - 1);
                }
                tmp *= 10;
                for (int i = 0; i < t.length; i++) {
                    tmp += a[r + i][k + t[0].length - 1] * (i + 1);
                }
            }
            if (val == tmp && doMatch(a, r, k, t) == true) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean doMatch(int[][] a, int r, int c, int[][] t) {
        for (int i = r; i < r + t.length; i++)
        	for (int j = c; j < c + t[0].length; j++)
        		if (a[i][j] != t[i - r][j - c])
        			return false;
        return true;
    }
}
