package ETL;

import java.util.Scanner;

public class TheGridSearch {

	private static int mod = 172314987;
	private static int base = 3;
	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int i = 0; i < cases; ++i) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            sc.nextLine();
            int[][] words = new int[m][n];
            for (int j = 0; j < m; ++j) {
                String s = sc.nextLine();
                for (int k = 0; k < n; ++k)
                    words[j][k] = (int)(s.charAt(k) - '0');
            }
            int pm = sc.nextInt();
            int pn = sc.nextInt();
            sc.nextLine();
            int[][] pattern = new int[pm][pn];
            for (int j = 0; j < pm; ++j) {
                String s = sc.nextLine();
                for (int k = 0; k < pn; ++k)
                    pattern[j][k] = (int)(s.charAt(k) - '0');
            }
            if (m < pm || n < pn) {
                System.out.println("NO");
                continue;
            }
            int[][] dp = new int[m - pm + 1][n - pn + 1];
            for (int a = 0; a < dp.length; ++a)
            	for (int b = 0; b < dp[0].length; ++b)
            		dp[a][b] = -1;
            dp[0][0] = calculateHashing(words, 0, 0, pm, pn);
            boolean result = canFind(words, pattern, calculateHashing(pattern, 0, 0, pm, pn), dp);
            if (result)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
    
    private static boolean canFind(int[][] words, int[][] pattern, int hashing, int[][] dp) {
    	for (int i = 0; i < words.length - pattern.length + 1; ++i)
        	for (int j = 0; j < words[0].length - pattern[0].length + 1; ++j) {
        		calculateHashing(words, i, j, pattern.length, pattern[0].length, dp);
        		if (dp[i][j] == hashing && match(words, pattern, i, j))
                    return true;
        	}
    	return false;
    }
    
    private static boolean match(int[][] words, int[][] pattern, int i, int j) {
        for (int m = i; m < i + pattern.length; ++m)
            for (int n = j; n < j + pattern[0].length; ++n)
                if (words[m][n] != pattern[m - i][n - j])
                    return false;
        return true;
    }
    
    private static int calculateHashing(int[][] words, int i, int j, int m, int n) {
        int result = 0;
        for (int a = i; a < m; ++a)
            for (int b = j; b < n; ++b)
                result = (result + (words[a][b] * (int)Math.pow(base, (a + b - i - j))) % mod) % mod;
        return result;
    }
    
    private static void calculateHashing(int[][] words, int i, int j, int m, int n, int[][] dp) {
        int result;
        if (i == 0 && j ==0)
            dp[0][0] = calculateHashing(words, 0, 0, m, n);
        else if (dp[i][j] >= 0)
        	return;
        else if (i > 0) {
            result = dp[i - 1][j];
            for (int k = j; k < j + n; ++k)
                result = result - words[i - 1][k] * (int)Math.pow(base, k - j);
            result = result / base;
            for (int k = j; k < j + n; ++k)
                result = result + words[i + m - 1][k] * (int)Math.pow(base, k - j + m - 1);
            if (result < 0)
            	result = result + mod;
            dp[i][j] = result;
        }
        else {
            result = dp[i][j - 1];
            for (int k = i; k < i + m; ++k)
                result = result - words[k][j - 1] * (int)Math.pow(base, k - i);
            result = result / base;
            for (int k = i; k < i + m; ++k)
                result = result + words[k][j + n - 1] * (int)Math.pow(base, k - i + n - 1); 
            if (result < 0)
            	result = result + mod;
            dp[i][j] = result;
        }
    }
    
}
