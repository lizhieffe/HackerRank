package ETL;

import java.util.Scanner;

public class SubsequenceWeighting {

	/*
	 * Solution should be:
	 * (see this link for binary index tree: http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=binaryIndexedTrees)
	 * Subsequence Weighting (Accepted, 30/30 points)

Let’s try solving it with a simple dynamic programming solution. Let dp[i] be the maximum weight of a subsequence that ends in a_{i}. The recurrence would be

dp[i] = w_{i} + max (dp[j]), where j < i and a_{j} < a_{i}.

Note that if we fill the dp table in ascending order of a_{i}, and in decreasing order of i for the same values of a_{i}, and set the unfilled entries of the dp table to 0, we can reduce the constraints into the above dp into:

dp[i] = w_{i} + max (dp[j]), where j < i.

The value of “max (dp[j]), where j < i” can be computed efficiently in O(log N) time complexity using a binary indexed tree. The solution to the original problem is then max (dp[i]) for all i. So, the total time complexity of this solution is O(N log N).
	 */
	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        long[] result = new long[T];
        for (int i = 0; i < T; i ++) {
            int N = in.nextInt();
            long[] a = new long[N];
            long[] w = new long[N];
            for (int j = 0; j < N; j ++)
                a[j] = in.nextLong();
            for (int j = 0; j < N; j ++)
                w[j] = in.nextLong();
            result[i] = findMax(a, w);
        }
        for (int i = 0; i < T; i ++)
            System.out.println(result[i]);
    }
    
    private static long findMax(long[] a, long[] w) {
    	long max = Long.MIN_VALUE;
    	long[] result = new long[a.length];
        for (int i = a.length - 1; i >= 0; i --) {
        	long tmp = 0;
            for (int j = i + 1; j < a.length; j ++) {
                if (a[i] < a[j] && tmp < result[j])
                    tmp = result[j];
            }
            result[i] = w[i] + tmp;
            if (max < result[i])
                max = result[i];
        }
        return max;
    }
}
