package Accepted;

import java.util.Scanner;

public class BDayGift {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double val = 0;
        for (int i = 0; i < n; i++)
            val += sc.nextInt();
        System.out.print((long)val / 2 + ".");
        if ((long)val % 2 == 0)
            System.out.println("0");
        else
            System.out.println("5");
    }
}
