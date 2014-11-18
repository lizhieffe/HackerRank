package Accepted;

import java.util.Scanner;

public class Restaurant {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int b = sc.nextInt();
            int size = gcd(l, b);
            System.out.println(l * b / size / size);
        }
    }
    
    private static int gcd(int i, int j) {
        if (i < j) {
            int tmp = i;
            i = j;
            j = i;
        }
        if (i % j == 0)
            return j;
        else
            return gcd(j, i % j);
    }
}
