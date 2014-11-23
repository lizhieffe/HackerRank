package Accepted;

import java.util.Scanner;

public class ReverseGame {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int mid = n / 2;
            if (k < mid)
                System.out.println(k * 2 + 1);
            else
                System.out.println((n - k - 1) * 2);
        }
    }
}
