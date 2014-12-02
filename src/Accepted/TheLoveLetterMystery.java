package Accepted;

import java.util.Scanner;

public class TheLoveLetterMystery {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < t; i++) {
            int result = 0;
            String s = sc.nextLine();
            char[] c = s.toCharArray();
            for (int j = 0; j < c.length / 2; j++)
                result += Math.abs(c[j] - c[c.length - j - 1]);
            System.out.println(result);
        }
    }
}
