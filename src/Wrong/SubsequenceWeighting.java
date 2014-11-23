package Wrong;

import java.util.Scanner;

public class SubsequenceWeighting {

private static long[] dp;
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] w = new int[n];
            dp = new long[n];
            for (int j = 0; j < n; j++)
                dp[j] = -1;
            for (int j = 0; j < n; j++)
                a[j] = sc.nextInt();
            for (int j = 0; j < n; j++)
                w[j] = sc.nextInt();
            System.out.println(maxWeight(a, w, 0));
        }
    }
    
    private static long maxWeight(int[] a, int[] w) {
        if (a == null || w == null || a.length == 0)
            return 0L;
        int min = Integer.MAX_VALUE;
        long result = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] <= min) {
                result = Math.max(result, maxWeight(a, w, i));
                min = a[i];
            }
        }
        return result;
    }
    
    private static long maxWeight(int[] a, int[] w, int beg) {
        if (beg == a.length - 1)
            return w[beg];
        if (dp[beg] != -1)
            return dp[beg];
        long result = w[beg];
        int min = Integer.MAX_VALUE;
        for (int i = beg + 1; i < a.length; i++) {
            if (a[i] > a[beg] && a[i] <= min) {
                result = Math.max(result, w[beg] + maxWeight(a, w, i));
                min = a[i];
            }
        }
        dp[beg] = result;
        return result;
    }
}
