package Accepted;

import java.util.Scanner;

public class FindDigits {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int count = 0;
            long num = sc.nextLong();
            long tmp = num;
            while (tmp != 0) {
                int digit = (int)tmp % 10;
                if (digit != 0 && num % digit == 0)
                    count++;
                tmp /= 10;
            }
            System.out.println(count);
        }
    }
	
	
}
