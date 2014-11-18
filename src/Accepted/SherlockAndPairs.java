package Accepted;

import java.util.Arrays;
import java.util.Scanner;

public class SherlockAndPairs {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long[] dp = new long[1000001];
        dp[1] = 0L;
        for (int i = 2; i <= 1000000; i++)
            dp[i] = dp[i - 1] + i - 1;
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++)
                a[j] = sc.nextInt();
            Arrays.sort(a);
            long result = 0;
            int last = 0;
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    last = a[j];
                    count = 1;
                }
                else if (a[j] != last && count > 1) {
                	last = a[j];
                    result += dp[count];
                    count = 1;
                }
                else if (a[j] != last) {
                	last = a[j];
                    count = 1;
                }
                else
                    count++;
            }
            if (count > 1){
                result += dp[count];
            }
            System.out.println(result * 2);
        }
    }
}
