package Accepted;

import java.util.Scanner;

public class FillingJars {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long total = 0;
        for (int i = 0; i < m; i++) {
            long beg = sc.nextLong();
            long end = sc.nextLong();
            long num = sc.nextLong();
            total += (end - beg + 1) * num;
        }
        System.out.println(total / n);
    }
}
