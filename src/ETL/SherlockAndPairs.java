package ETL;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class SherlockAndPairs {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        int[] results = new int[cases];
        for (int i = 0; i < cases; i ++) {
            int n = in.nextInt();
            in.nextLine();
            String str = in.nextLine();
            String[] strAr = str.split(" ");            
            Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
            for (int j = 0; j < n; j ++) {
                int val = Integer.parseInt(strAr[j]);
                Integer times = table.get(val);
                times = (times == null) ? 1 : times + 1;
                table.put(val, times);
            }
            Enumeration<Integer> enumKeys = table.keys();
            while (enumKeys.hasMoreElements()) {
                Integer key = enumKeys.nextElement();
                Integer tmp = table.get(key);
                results[i] += getPairs(tmp);
            }
        }
        for (int i = 0; i < cases; i ++)
            System.out.println(results[i]);
    }
    
    private static int getPairs(int i) {
    	return i * (i - 1);
    }
}
