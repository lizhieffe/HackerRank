package Accepted;

import java.util.Scanner;

public class GameOfRotation {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long[] a = new long[N];
        for (int i = 0; i < N; i ++)
            a[i] = in.nextLong();
        long max = 0;
        long tmp = 0;
        long sum = 0;
        for (int i = 0; i < N; i ++) {
            tmp += (i + 1) * a[i];
            sum += a[i];
        }
        max = tmp;
        for (int i = 0; i < N - 1; i ++) {
            tmp = tmp - sum + a[i] * N;
            if (max < tmp)
                max = tmp;
        }
        System.out.println(max);
    }
}
