package Accepted;

import java.util.Scanner;

public class CounterGame {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        String[] N = new String[T];
        for (int i = 0; i < T; i ++)
            N[i] = in.nextBigInteger().toString(2);
        for (int i = 0; i < T; i ++)
            System.out.println(findWinner(N[i]));
    }
    
    private static String findWinner(String i) {
        int count = 0;
        while (i.length() > 1) {
        	if (i.charAt(i.length() - 1) == '0') {
        		i = i.substring(0, i.length() - 1);
        		count ++;
        	}
        	else if (i.charAt(0) == '1') {
        		i = i.substring(1, i.length());
        		count ++;
        	}
        	else if (i.charAt(0) == '0')
        		i = i.substring(1, i.length());
        }
        if ((count & 1) == 1)
            return "Louise";
        else
            return "Richard";
    }
}
