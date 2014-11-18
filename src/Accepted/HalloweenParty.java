package Accepted;

import java.util.Scanner;

public class HalloweenParty {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            long v = sc.nextLong();
            System.out.println((v / 2) * (v - v / 2));
        }
        
    }
}
