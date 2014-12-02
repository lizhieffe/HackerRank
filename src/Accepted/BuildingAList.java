package Accepted;

import java.util.Arrays;
import java.util.Scanner;

public class BuildingAList {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            char[] c = s.toCharArray();
            Arrays.sort(c);
            findCombinations(c, 0, "");
        }
    }
    
    private static void findCombinations(char[] c, int beg, String solution) {
        if (beg >= c.length)
            return;
        String tmp = solution + c[beg];
        System.out.println(tmp);
        findCombinations(c, beg + 1, tmp);
        findCombinations(c, beg + 1, solution);
    }
}
