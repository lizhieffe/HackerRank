package Accepted;

import java.util.Scanner;

public class AlternatingCharacter {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            int result = 0;
            String s = sc.nextLine();
            if (s.length() != 0) {
                char last = s.charAt(0);
                for (int j = 1; j < s.length(); j++) {
                    if (last == s.charAt(j))
                        result++;
                    else
                        last = s.charAt(j);
                }
            }
            System.out.println(result);  
        }
    }
}
