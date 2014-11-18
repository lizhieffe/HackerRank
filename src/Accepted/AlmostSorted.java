package Accepted;

import java.util.Arrays;
import java.util.Scanner;

public class AlmostSorted {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = s.nextInt();
        int[] b = new int[n];
        System.arraycopy(a, 0, b, 0, a.length);
        Arrays.sort(b);
        
        int diff = 0;
        int first = -1;
        int last = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                if (diff == 0) {
                    first = i + 1;
                    diff++;
                }
                else {
                    last = i + 1;
                    diff++;
                }
            }
        }
        
        if (diff == 0)
            System.out.println("yes");
        else if (diff == 2) {
            System.out.println("yes");
            System.out.println("swap " + first + " " + last);
        }
        else {
            for (int i = first - 1; i <= last - 1; i++) {
                if (a[i] != b [last - 1 - i + first - 1]) {
                    System.out.println("no");
                    return;
                }
            }
            System.out.println("yes");
            System.out.println("reverse " + first + " " + last);
        }
    }
}
