package Accepted;

import java.util.Scanner;

public class ACMTeam {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[][] array = new boolean[n][m];
    	sc.nextLine();
        for (int i = 0; i < n; i++) {
        	String s = sc.nextLine();
        	char[] c = s.toCharArray();
        	for (int j = 0; j < m; j++)
        		array[i][j] = (c[j] == '0') ? false : true;
        }
        int max = 0;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int val = count(array[i], array[j]);
                if (val > max) {
                    max =  val;
                    count = 1;
                }
                else if (val == max)
                    count++;
            }
        }
        System.out.println(max);
        System.out.println(count);
    }
    
    private static int count(boolean[] a, boolean[] b) {
        int count = 0;
        for (int i = 0; i < a.length; i++)
            if (a[i] == true || b[i] == true)
                count++;
        return count;
    }
}