package Accepted;

import java.util.Scanner;

public class CommonChild {

	int[][] dp;
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(new CommonChild().maxChild(s1, s2));
    }
    
    public int maxChild(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0)
            return 0;
        dp = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++)
            for (int j = 0; j < s2.length(); j++)
                dp[i][j] = -1;
        return maxChild(s1, 0, s2, 0);
    }
    
    private int maxChild(String s1, int beg1, String s2, int beg2) {
        if (beg1 >= s1.length() || beg2 >= s2.length())
            return 0;
        if (dp[beg1][beg2] != -1)
            return dp[beg1][beg2];
        int result = 0;
        if (s1.charAt(beg1) == s2.charAt(beg2))
            result = 1 + maxChild(s1, beg1 + 1, s2, beg2 + 1);
        else {
            result = Math.max(maxChild(s1, beg1 + 1, s2, beg2), maxChild(s1, beg1, s2, beg2 + 1));
        }
        dp[beg1][beg2] = result;
        return result;
    }
}
