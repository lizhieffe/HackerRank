package Accepted;

import java.util.Scanner;

public class SherlockAndWatson {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int q = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
        a[i] = sc.nextInt();
        for (int i = 0; i < q; i++) {
        System.out.println(a[getIndex(sc.nextInt(), n, k)]);
        }
    }

    private static int getIndex(int i, int n, int k) {
    int result = (i - k) % n;
    if (result < 0)
    result += n;
    return result;
    }
}
