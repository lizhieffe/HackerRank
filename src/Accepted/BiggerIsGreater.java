package Accepted;

import java.util.Scanner;

public class BiggerIsGreater {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String result = findNext(s);
            if (result == null)
                System.out.println("no answer");
            else
                System.out.println(result);
        }
    }
    
    public static String findNext(String s) {
        if (s == null || s.length() < 2)
            return null;
        char[] c = s.toCharArray();
        int i;
        for (i = c.length -1; i >= 0; i--) {
            if (i == 0)
                return null;
            if ((int)c[i-1] < (int)c[i])
                break;
        }
        int j;
        for (j = c.length - 1; j >= i; j--)
            if ((int)c[i-1] < (int)c[j])
                break;
        swap(c, i - 1, j);
        reverse(c, i, c.length - 1);
        return String.valueOf(c);
    }
    
    private static void swap(char[] c, int i, int j) {
        char tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }
    
    private static void reverse(char[] c, int beg, int end) {
        while (beg < end) {
            swap(c, beg, end);
            beg++;
            end--;
        }
    }
}
