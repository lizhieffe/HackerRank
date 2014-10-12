package Accepted;

import java.util.Scanner;

public class PalindromeIndex {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        String[] strings = new String[num];
        for (int i = 0; i < num; i ++)
            strings[i] = in.next();
        for (int i = 0; i < num; i ++) {
            System.out.println(indexToRemove(strings[i]));
        }
    }
    
    private static int indexToRemove(String s) {
        if (s == null || s.length() <= 1)
            return -1;
        return indexToRemove(s, 0, s.length() - 1);
    }
    
    private static int indexToRemove(String s, int beg, int end) {
        for (int i = beg; i < (end - beg) / 2; i ++) {
            if (s.charAt(i) != s.charAt(end - i)) {
                if (isPalindrome(s, i + 1, end - i) == true)
                    return i;
                else
                    return end - i;
            }
        }
        return -1;
    }
    
    private static boolean isPalindrome(String s, int beg, int end) {
    	for (int i = beg; i < (end - beg) / 2 + beg; i ++) {
    		if (s.charAt(i) != s.charAt(end - i + beg))
    			return false;
    	}
    	return true;
    }
}
