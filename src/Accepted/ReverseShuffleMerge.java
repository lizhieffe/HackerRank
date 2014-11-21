package Accepted;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ReverseShuffleMerge {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] c = s.toCharArray();
        int[] count = new int[26];
        for (int i = 0; i < c.length; i++)
            count[c[i] - 'a']++;
        for (int i = 0; i < count.length; i++)
            count[i] = count[i] / 2;
        List<String> result = new ArrayList<String>();
        char[] solution = new char[c.length / 2];
        findSolution(c, 0, count, result, solution, 0);
        Collections.sort(result);
        System.out.println(result.get(0));
    }
    
    private static void findSolution(char[] source, int beg, int[] count
                             , List<String> result, char[] solution, int sBeg) {
        if (sBeg >= solution.length) {
            result.add(String.copyValueOf(solution));
            return;
        }
        if (beg >= source.length)
            return;
        for (int i = beg; i < source.length - (solution.length - sBeg); i++) {
        	if (count[source[i] - 'a'] > 0) {
                char[] tSolution = new char[solution.length];
                System.arraycopy(solution, 0, tSolution, 0, solution.length);
                tSolution[sBeg] = source[i];
                int[] tCount = new int[count.length];
                System.arraycopy(count, 0, tCount, 0, count.length);
                tCount[source[i] - 'a']--;
                findSolution(source, i + 1, tCount, result, tSolution, sBeg + 1);
            }
        }
        
    }
}
