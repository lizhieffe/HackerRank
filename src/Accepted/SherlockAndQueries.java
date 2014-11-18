package Accepted;

import java.util.Scanner;

public class SherlockAndQueries {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] a = new long[n];
        int[] b = new int[m];
        long[] c = new long[m];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextLong();
        for (int i = 0; i < m; i++)
            b[i] = sc.nextInt();
        for (int i = 0; i < m; i++)
            c[i] = sc.nextLong();
        for (int i = 1; i <= m; i++) {
            int vb = b[i - 1];
            long tmp = (long)vb;
            while (tmp <= n) {
                a[(int)tmp - 1] = (a[(int)tmp - 1] * c[i - 1]) % 1000000007;
                tmp += vb;
            }
        }
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
    }
}
