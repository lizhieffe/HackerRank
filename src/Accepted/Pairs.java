package Accepted;

import java.util.Arrays;
import java.util.Scanner;

public class Pairs {

	static int pairs(int[] a,int k) {
	      /* Complete this function */

	        if (k == 0)
	            return a.length;
	        
			Arrays.sort(a);
	        k = Math.abs(k);
	        int i = 0;
	        int j = 0;
	        
	        int result = 0;
	        while (j < a.length) {
	            if (a[j] - a[i] == k) {
	                result ++;
	                i ++;
	                j ++;
	            }
	            else if (a[j] - a[i] > k)
	                i ++;
	            else
	                j ++;
	        }
	        return result;
	    }

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int res;
	        
	        String n = in.nextLine();
	        String[] n_split = n.split(" ");
	        
	        int _a_size = Integer.parseInt(n_split[0]);
	        int _k = Integer.parseInt(n_split[1]);
	        
	        int[] _a = new int[_a_size];
	        int _a_item;
	        String next = in.nextLine();
	        String[] next_split = next.split(" ");
	        
	        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
	            _a_item = Integer.parseInt(next_split[_a_i]);
	            _a[_a_i] = _a_item;
	        }
	        
	        res = pairs(_a,_k);
	        System.out.println(res);
	    }
}
