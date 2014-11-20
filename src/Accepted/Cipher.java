package Accepted;

import java.util.Scanner;

public class Cipher {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        boolean[] b = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++)
            b[i] = s.charAt(i) == '1' ? true : false;
        boolean[] a = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (i == 0)
                a[i] = b[i];
            else if (i < k) {
            	a[i] = b[i] ^ b[i - 1];
            }
            else {
                a[i] = b[i] ^ b[i - 1] ^ a[i - k];
            }
                
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++)
            builder.append((a[i] == true) ? '1' : '0');
        System.out.println(builder.toString());
    }
}
