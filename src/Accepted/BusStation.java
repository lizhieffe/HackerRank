package Accepted;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BusStation {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i ++) {
            a[i] = in.nextInt();
            sum += a[i];
        }
        int tmp = 0;
        List<Integer> size = new ArrayList<Integer>();
        for (int i = 0; i < n; i ++) {
            tmp += a[i];
            if (sum % tmp == 0 && doesSizeWork(tmp, a, i + 1))
                size.add(tmp);
        }
        for (int i = 0; i < size.size(); i ++) {
            System.out.print(size.get(i));
            if (i != size.size())
                System.out.print(" ");
        }
    }
    
    static boolean doesSizeWork(int size, int[] a, int beg) {
        if (beg >= a.length)
            return true;
        int tmp = 0;
        for (int i = beg; i < a.length; i ++) {
            tmp += a[i];
            if (tmp == size)
                return doesSizeWork(size, a, i + 1);
            else if (tmp > size)
                return false;
        }
        return false;
    }
}
